package jp.s6n.idea.ghactions.context

interface Object : Item {
    fun find(name: String): Item?
}
