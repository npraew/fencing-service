package com.agoda.demo.workflow.orchestrator.core
import com.agoda.demo.workflow.orchestrator.core.message.MessageConsumer
import org.slf4j.LoggerFactory
import java.util.Optional
import kotlin.concurrent.thread
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor


fun main() {

    val logger = LoggerFactory.getLogger("Main")

    val config =MessageConsumerConfig(
        username = "devrabbit",
        password = "123456",
        queue = "my-queue"
    )

    val noArgInstance = Class.forName("com.agoda.demo.workflow.orchestrator.core.NoArg").kotlin.createInstance()
    val requiredArgInstance = Class.forName("com.agoda.demo.workflow.orchestrator.core.RequiredArgs")
        .kotlin.primaryConstructor!!.call("test",20)
//        .getDeclaredConstructor().newInstance()
    val a = Optional.ofNullable(noArgInstance)
    println(noArgInstance)
    println(requiredArgInstance)

    val thread = thread(start = true) {
        val consumer = MessageConsumer(config)
        consumer.start()
        logger.info("${Thread.currentThread()} has run.")
    }
    thread.start()
}
object ObjNoArg
class NoArg
class OptionalArgs(val arg: String = "default")
class RequiredArgs(val arg1: String, val arg2: Int) {
    constructor(arg1: String): this(arg1, 20)
}