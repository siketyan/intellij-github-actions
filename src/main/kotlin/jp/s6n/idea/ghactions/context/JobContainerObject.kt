package jp.s6n.idea.ghactions.context

class JobContainerObject : AbstractObject() {
    init {
        addProperty("id", Item.Type.STRING, "The ID of the container.")
        addProperty("network", Item.Type.STRING, "The ID of the container network.")
    }

    override fun name(): String = "container"

    override fun summary(): String = "Information about the job's container."

    companion object {
        val INSTANCE = JobContainerObject()
    }
}
