package jp.s6n.idea.ghactions.context

class JobObject : AbstractObject() {
    init {
        add("container", JobContainerObject.INSTANCE)

        addProperty(
            "status", Item.Type.STRING,
            "The current status of the job."
        )
    }

    override fun summary(): String = "Information about the currently running job."

    companion object {
        val INSTANCE = JobObject()
    }
}
