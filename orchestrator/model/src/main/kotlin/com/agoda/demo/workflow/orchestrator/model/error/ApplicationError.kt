package com.agoda.demo.workflow.orchestrator.model.error



data class BookingNotFound(val bookingId:Long) : ApplicationError(
    "bookingId:$bookingId not found"
)
