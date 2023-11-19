package jp.s6n.idea.ghactions.context

class JobObject : AbstractObject() {
    init {
        add(JobContainerObject.INSTANCE)

        addProperty(
            "status", Item.Type.STRING,
            "The current status of the job."
        )
    }

    override fun name(): String = "job"

    override fun summary(): String = "Information about the currently running job."

    companion object {
        val INSTANCE = JobObject()
    }
}
