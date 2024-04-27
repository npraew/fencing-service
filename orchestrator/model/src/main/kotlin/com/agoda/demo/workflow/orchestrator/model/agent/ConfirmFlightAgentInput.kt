package com.agoda.demo.workflow.orchestrator.model.agent

import com.agoda.demo.workflow.orchestrator.external.create.Flight


interface ConfirmFlightAgentInput {
    fun flightDetail(bookingId:Long): Result<Flight.FlightInfo>
}