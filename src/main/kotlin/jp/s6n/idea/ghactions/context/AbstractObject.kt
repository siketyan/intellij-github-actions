package jp.s6n.idea.ghactions.context

abstract class AbstractObject : Object {
    private val items: MutableMap<String, Item> = mutableMapOf()

    override fun find(name: String): Item? = items[name]

    override fun type(): Item.Type = Item.Type.OBJECT

    override fun children(): List<Pair<String, Item>> = items.entries.map { e -> Pair(e.key, e.value) }

    protected fun add(name: String, item: Item) {
        items[name] = item
    }

    protected fun addProperty(name: String, type: Item.Type, summary: String) =
        add(name, Property(this, type, summary))
}
