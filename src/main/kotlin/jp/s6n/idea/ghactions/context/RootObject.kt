package jp.s6n.idea.ghactions.context

class RootObject : AbstractObject() {
    init {
        add(GitHubObject.INSTANCE)
    }

    override fun name(): String = ""

    companion object {
        val INSTANCE = RootObject()
    }
}
