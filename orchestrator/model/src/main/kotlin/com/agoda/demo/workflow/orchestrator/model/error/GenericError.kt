package com.agoda.demo.workflow.orchestrator.model.error

sealed class GenericError(message:String, cause:Throwable?): Throwable(message, cause)

open class ApplicationError(message:String): GenericError(message, null)
open class ConnectionError(message:String, cause:Throwable?): GenericError(message, cause)
