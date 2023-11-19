package jp.s6n.idea.ghactions.context

object EnvObject : AbstractObject() {
    override fun summary(): String = "Contains variables set in a workflow, job, or step."
}
