package jp.s6n.idea.ghactions.context

abstract class AbstractObject(vararg items: Item) : Object {
    private val items: MutableMap<String, Item> = items.associateBy { it.name() }.toMutableMap()

    override fun find(name: String): Item? = items[name]

    override fun children(): List<Item> = items.values.toList()

    protected fun add(item: Item) {
        items[item.name()] = item
    }

    protected fun addProperty(name: String, type: Property.Type, summary: String) =
        add(Property(this, name, type, summary))
}
