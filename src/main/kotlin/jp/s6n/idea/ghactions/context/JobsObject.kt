package jp.s6n.idea.ghactions.context

import jp.s6n.idea.ghactions.schema.Job
import jp.s6n.idea.ghactions.schema.Workflow

class JobsObject(
    workflow: Workflow,
) : AbstractObject() {
    class JobItem(job: Job) : AbstractObject() {
        class Outputs(outputs: Map<String, String>) : AbstractObject() {
            init {
                outputs.keys.forEach { name ->
                    addProperty(
                        name, Item.Type.STRING,
                        "The value of a specific output for a job in a reusable workflow.",
                    )
                }
            }

            override fun summary(): String = "The set of outputs of a job in a reusable workflow."
        }

        init {
            addProperty("result", Item.Type.STRING, "The result of a job in the reusable workflow.")

            job.outputs?.let {
                add("outputs", Outputs(it))
            }
        }
    }

    init {
        workflow.jobs?.forEach { (name, job) ->
            add(name, JobItem(job))
        }
    }

    override fun summary(): String = "Information about the currently running job."
}
