package jp.s6n.idea.ghactions.context

object VarsObject : AbstractObject() {
    override fun summary(): String = "Contains variables set at the repository, organization, or environment levels."
}
