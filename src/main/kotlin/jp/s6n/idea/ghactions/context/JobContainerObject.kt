package jp.s6n.idea.ghactions.context

class JobContainerObject : AbstractObject() {
    init {
        addProperty("id", Property.Type.STRING, "The ID of the container.")
        addProperty("network", Property.Type.STRING, "The ID of the container network.")
    }

    override fun name(): String = "container"

    companion object {
        val INSTANCE = JobContainerObject()
    }
}
