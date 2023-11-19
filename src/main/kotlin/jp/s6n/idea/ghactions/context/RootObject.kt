package jp.s6n.idea.ghactions.context

class RootObject : AbstractObject() {
    init {
        add("github", GitHubObject.INSTANCE)
        add("job", JobObject.INSTANCE)
        add("runner", RunnerObject.INSTANCE)
        add("secrets", SecretsObject.INSTANCE)
        add("strategy", StrategyObject.INSTANCE)
    }

    override fun summary(): String = ""

    companion object {
        val INSTANCE = RootObject()
    }
}
