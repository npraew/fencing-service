package agoda.demo.workflow.orchestrator.agent.common

interface Processor<In,Out> {
    fun process(input:In): Result<Out>
}