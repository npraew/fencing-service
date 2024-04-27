package com.agoda.demo.workflow.orchestrator.core

data class MessageConsumerConfig(
    val username:String,
    val password:String,
    val queue: String,
)