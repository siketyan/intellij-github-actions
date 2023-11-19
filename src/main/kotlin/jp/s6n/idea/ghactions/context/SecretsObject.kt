package jp.s6n.idea.ghactions.context

class SecretsObject : AbstractObject() {
    init {
        addProperty(
            "GITHUB_TOKEN", Property.Type.STRING,
            "Automatically created token for each workflow run.",
        )
    }

    override fun name(): String = "secrets"

    companion object {
        val INSTANCE = SecretsObject()
    }
}
