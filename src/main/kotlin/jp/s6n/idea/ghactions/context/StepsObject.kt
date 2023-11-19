package jp.s6n.idea.ghactions.context

import jp.s6n.idea.ghactions.schema.Step

class StepsObject(steps: List<Step>) : AbstractObject() {
    object StepObject : AbstractObject() {
        object Outputs : AbstractObject() {
            override fun summary(): String = "The set of outputs defined for the step."
        }

        init {
            add("outputs", Outputs)

            addProperty(
                "conclusion", Item.Type.STRING,
                "The result of a completed step after continue-on-error is applied.",
            )
            addProperty(
                "outcome", Item.Type.STRING,
                "The result of a completed step before continue-on-error is applied.",
            )
        }
    }

    init {
        steps.mapNotNull { it.id }.forEach { id ->
            add(id, StepObject)
        }
    }

    override fun summary(): String = "Information about the steps that have been run in the current job."
}
