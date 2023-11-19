package jp.s6n.idea.ghactions.context

class RootObject : AbstractObject() {
    init {
        add(GitHubObject.INSTANCE)
        add(JobObject.INSTANCE)
        add(RunnerObject.INSTANCE)
        add(SecretsObject.INSTANCE)
        add(StrategyObject.INSTANCE)
    }

    override fun name(): String = ""

    override fun summary(): String = ""

    companion object {
        val INSTANCE = RootObject()
    }
}
