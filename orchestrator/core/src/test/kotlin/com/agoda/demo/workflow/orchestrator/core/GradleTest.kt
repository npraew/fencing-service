package com.agoda.demo.workflow.orchestrator.core

import com.agoda.demo.workflow.orchestrator.external.create.Request.CreateBookingRequest
import com.agoda.demo.workflow.orchestrator.external.create.createBookingRequest
import org.junit.Test

internal class GradleExampleTest {

    @Test
    fun shouldRun() {
        val req:CreateBookingRequest = createBookingRequest {

        }
        println(req)
        println("hello world")
    }
}
