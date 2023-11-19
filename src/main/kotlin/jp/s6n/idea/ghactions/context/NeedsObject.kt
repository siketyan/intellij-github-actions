package jp.s6n.idea.ghactions.context

import jp.s6n.idea.ghactions.schema.Job
import jp.s6n.idea.ghactions.schema.Workflow

class NeedsObject(
    workflow: Workflow,
    needs: List<String>,
) : AbstractObject() {
    class NeedItem(job: Job) : AbstractObject() {
        class Outputs(outputs: Map<String, String>) : AbstractObject() {
            init {
                outputs.keys.forEach { name ->
                    addProperty(
                        name, Item.Type.STRING,
                        "The value of a specific output for a job that the current job depends on.",
                    )
                }
            }

            override fun summary(): String = "The set of outputs of a job that the current job depends on."
        }

        init {
            addProperty(
                "result", Item.Type.STRING,
                "The result of a job that the current job depends on.",
            )

            job.outputs?.let {
                add("outputs", Outputs(it))
            }
        }

        override fun summary(): String = "A single job that the current job depends on."
    }

    init {
        needs.forEach { name ->
            workflow.jobs?.get(name)?.let {
                add(name, NeedItem(it))
            }
        }
    }

    override fun summary(): String =
        "Contains the outputs of all jobs that are defined as a dependency of the current job."
}
