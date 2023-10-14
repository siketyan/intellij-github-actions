package jp.s6n.idea.ghactions.schema

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTransformingSerializer

@Serializable(with = Concurrency.Serializer::class)
data class Concurrency(
    val group: String? = null,
    val cancelInProgress: Boolean? = null,
) {
    object Serializer : JsonTransformingSerializer<Concurrency>(serializer()) {
        override fun transformDeserialize(element: JsonElement): JsonElement =
            if (element is JsonObject) element else JsonObject(mapOf(Pair("group", element)))
    }
}
