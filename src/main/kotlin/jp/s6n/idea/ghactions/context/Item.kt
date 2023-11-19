package jp.s6n.idea.ghactions.context

interface Item {
    enum class Type {
        BOOLEAN {
            override fun toString(): String = "boolean"
        },
        INTEGER {
            override fun toString(): String = "integer"
        },
        STRING {
            override fun toString(): String = "string"
        },
        OBJECT {
            override fun toString(): String = "object"
        }
    }

    fun name(): String

    fun type(): Type

    fun summary(): String

    fun children(): List<Pair<String, Item>> = listOf()
}
