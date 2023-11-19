package jp.s6n.idea.ghactions.context

class JobObject : AbstractObject() {
    init {
        add(JobContainerObject.INSTANCE)

        addProperty(
            "status", Property.Type.STRING,
            "The current status of the job."
        )
    }

    override fun name(): String = "job"

    companion object {
        val INSTANCE = JobObject()
    }
}
