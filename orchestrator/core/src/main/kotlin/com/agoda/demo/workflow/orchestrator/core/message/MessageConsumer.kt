package com.agoda.demo.workflow.orchestrator.core.message

import com.agoda.demo.workflow.orchestrator.core.MessageConsumerConfig

import com.rabbitmq.client.*
import org.slf4j.LoggerFactory
import java.util.concurrent.*
import kotlin.concurrent.thread

class MessageConsumer(val config: MessageConsumerConfig){
    val logger = LoggerFactory.getLogger(MessageConsumer::class.java)

    val working = mutableListOf<Thread>()

    val factory = ConnectionFactory()
        .apply {
            username = config.username
            password = config.password
            host = ConnectionFactory.DEFAULT_HOST
            virtualHost = ConnectionFactory.DEFAULT_VHOST
            port = ConnectionFactory.DEFAULT_AMQP_PORT
        }

    val channel = factory
        .newConnection()
        .createChannel()

    fun noticeListener(t:Thread){
        working.remove(t)
    }

    val corePoolSize = 4
    val maximumPoolSize = corePoolSize * 4
    val keepAliveTime = 100L
    val workQueue = SynchronousQueue<Runnable>()
    val workerPool: ExecutorService = ThreadPoolExecutor(
        corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue
    )

    fun start() {
        channel.basicConsume(config.queue, true, object : Consumer {
            override fun handleConsumeOk(consumerTag: String?) {
                consumerTag?.let {
                    println("$it has been registered as a callback")
                }
            }

            override fun handleCancelOk(consumerTag: String?) {
                //Perform cancellation tasks such as closing resources here
            }

            override fun handleCancel(consumerTag: String?) {
                //Perform cancellation tasks such as closing resources here
            }

            override fun handleShutdownSignal(consumerTag: String?, sig: ShutdownSignalException?) {
                sig?.let {
                    throw it
                }
            }

            override fun handleRecoverOk(consumerTag: String?) {
                // If connection issues, try to receive messages again
            }

            override fun handleDelivery(
                consumerTag: String?,
                envelope: Envelope?,
                properties: AMQP.BasicProperties?,
                body: ByteArray?
            ) {
                body?.let {
                    logger.info((it.decodeToString()))
                }
                logger.info("current list: ${workQueue.size}")
//                val t = thread(start = true) {
//                    Thread.sleep(10000)
//                    noticeListener(Thread.currentThread())
//                    logger.info("${Thread.currentThread().name} - thread end")
//                }

                val f = workerPool.submit {
                    Thread.sleep(10000) // Imitate slow IO
                    println("I am reporting on the progress")
                    throw Exception("agent error")
                }


//                working.add(t)
            }

        })
    }
}