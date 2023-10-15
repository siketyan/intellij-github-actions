package jp.s6n.idea.ghactions.context

interface Item {
    fun name(): String
    fun children(): List<Item> = listOf()
}
