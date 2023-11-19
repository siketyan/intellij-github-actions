package jp.s6n.idea.ghactions.context

class RunnerObject : AbstractObject() {
    init {
        addProperty(
            "name", Item.Type.STRING,
            "The name of the runner executing the job.",
        )
        addProperty(
            "os", Item.Type.STRING,
            "The operating system of the runner executing the job.",
        )
        addProperty(
            "arch", Item.Type.STRING,
            "The architecture of the runner executing the job.",
        )
        addProperty(
            "temp", Item.Type.STRING,
            "The path to a temporary directory on the runner.",
        )
        addProperty(
            "tool_cache", Item.Type.STRING,
            "The path to the directory containing preinstalled tools for GitHub-hosted runners.",
        )
        addProperty(
            "debug", Item.Type.STRING,
            "This is set only if debug logging is enabled, and always has the value of 1.",
        )
    }

    override fun summary(): String = "Information about the runner that is running the current job."

    companion object {
        val INSTANCE = RunnerObject()
    }
}
