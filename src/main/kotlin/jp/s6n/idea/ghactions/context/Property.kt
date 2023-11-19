package jp.s6n.idea.ghactions.context

class Property(
    val parent: Object,
    val name: String,
    val type: Item.Type,
    val summary: String,
) : Item {
    override fun name(): String = name

    override fun type(): Item.Type = type

    override fun summary(): String = summary
}
