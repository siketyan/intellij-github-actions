package jp.s6n.idea.ghactions.context

class RunnerObject : AbstractObject() {
    init {
        addProperty(
            "name", Property.Type.STRING,
            "The name of the runner executing the job.",
        )
        addProperty(
            "os", Property.Type.STRING,
            "The operating system of the runner executing the job.",
        )
        addProperty(
            "arch", Property.Type.STRING,
            "The architecture of the runner executing the job.",
        )
        addProperty(
            "temp", Property.Type.STRING,
            "The path to a temporary directory on the runner.",
        )
        addProperty(
            "tool_cache", Property.Type.STRING,
            "The path to the directory containing preinstalled tools for GitHub-hosted runners.",
        )
        addProperty(
            "debug", Property.Type.STRING,
            "This is set only if debug logging is enabled, and always has the value of 1.",
        )
    }

    override fun name(): String = "runner"

    companion object {
        val INSTANCE = RunnerObject()
    }
}
