package jp.s6n.idea.ghactions.context

abstract class AbstractObject(vararg items: Item) : Object {
    private val items: MutableMap<String, Item> = items.associateBy { it.name() }.toMutableMap()

    override fun find(name: String): Item? = items[name]

    override fun type(): Item.Type = Item.Type.OBJECT

    override fun children(): List<Pair<String, Item>> = items.entries.map { e -> Pair(e.key, e.value) }

    protected fun add(item: Item) {
        items[item.name()] = item
    }

    protected fun addProperty(name: String, type: Item.Type, summary: String) =
        add(Property(this, name, type, summary))
}
