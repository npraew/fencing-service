package agoda.demo.workflow.orchestrator.agent.flight

import agoda.demo.workflow.orchestrator.agent.common.Processor
import com.agoda.demo.workflow.orchestrator.model.agent.ConfirmFlightAgentInput

class ConfirmBookingProcessor(): Processor<ConfirmFlightAgentInput, String> {
    override fun process(input: ConfirmFlightAgentInput): Result<String> {
        TODO("Not yet implemented")
    }
}