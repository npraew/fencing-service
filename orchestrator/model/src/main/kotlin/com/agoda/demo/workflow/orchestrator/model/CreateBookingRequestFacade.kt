package com.agoda.demo.workflow.orchestrator.model

import com.agoda.demo.workflow.orchestrator.external.create.Flight
import com.agoda.demo.workflow.orchestrator.external.create.Request.CreateBookingRequest
import com.agoda.demo.workflow.orchestrator.model.agent.ConfirmFlightAgentInput
import com.agoda.demo.workflow.orchestrator.model.error.BookingNotFound
import java.util.*
import kotlin.jvm.optionals.getOrElse


class CreateBookingRequestFacade(private val request:CreateBookingRequest) :
    ConfirmFlightAgentInput {

    override fun flightDetail(bookingId:Long): Result<Flight.FlightInfo> {
        return Optional.ofNullable(
            request.productsList.find { it.bookingId == bookingId }?.detail?.flight
        ).map { Result.success(it) }.getOrElse { Result.failure(BookingNotFound(bookingId)) }
    }
}