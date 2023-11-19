package jp.s6n.idea.ghactions.context

class SecretsObject : AbstractObject() {
    init {
        addProperty(
            "GITHUB_TOKEN", Item.Type.STRING,
            "Automatically created token for each workflow run.",
        )
    }

    override fun summary(): String = "Contains the names and values of secrets that are available to a workflow run."

    companion object {
        val INSTANCE = SecretsObject()
    }
}
