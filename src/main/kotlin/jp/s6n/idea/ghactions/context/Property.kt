package jp.s6n.idea.ghactions.context

class Property(
    val parent: Object,
    val name: String,
    val type: Type,
    val summary: String,
) : Item {
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
    }

    override fun name(): String = name
}
