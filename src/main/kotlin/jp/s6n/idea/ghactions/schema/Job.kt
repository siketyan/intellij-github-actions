package jp.s6n.idea.ghactions.schema

import jp.s6n.idea.ghactions.schema.serialization.StringOrStringArraySerializer
import kotlinx.serialization.*
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*
import kotlinx.serialization.json.Json.Default.encodeToString

@Serializable
data class Job(
    val name: String? = null,
    val permissions: Permissions? = null,
    @Serializable(with = StringOrStringArraySerializer::class)
    val needs: List<String>? = null,
    @SerialName("if")
    val runsIf: String? = null,
    val runsOn: String? = null,
    @Serializable(with = Environment.Serializer::class)
    val environment: Environment? = null,
    @Serializable(with = Concurrency.Serializer::class)
    val concurrency: Concurrency? = null,
    val outputs: Map<String, String>? = null,
    val env: Map<String, String>? = null,
    val defaults: Defaults? = null,
    val steps: List<Step>? = null,
    val timeoutMinutes: Int? = null,
    val strategy: Strategy? = null,
    val continueOnError: Boolean? = null,
    val container: Container? = null,
    val services: Map<String, Container>? = null,
    val uses: String? = null,
    val with: Map<String, String>? = null,
    // TODO: secrets
) {
    @Serializable
    data class Environment(
        val name: String? = null,
        val url: String? = null,
    ) {
        object Serializer : JsonTransformingSerializer<Environment>(serializer()) {
            override fun transformDeserialize(element: JsonElement): JsonElement =
                if (element is JsonObject) element else JsonObject(mapOf(Pair("name", element)))
        }
    }

    @Serializable
    data class Strategy(
        val matrix: Matrix? = null,
        val failFast: Boolean? = null,
        val maxParallel: Int? = null,
    ) {
        @Serializable(with = Matrix.Serializer::class)
        data class Matrix(
            val dimensions: Map<String, List<String>> = mapOf(),
            val include: List<Map<String, String>>? = null,
        ) {
            object Serializer : KSerializer<Matrix> {
                private const val INCLUDE_FIELD_NAME = "include"
                private val mapSerializer = MapSerializer(String.serializer(), JsonElement.serializer())

                @ExperimentalSerializationApi
                override val descriptor: SerialDescriptor = object : SerialDescriptor by mapSerializer.descriptor {
                    override val serialName: String = "Responses"
                }

                override fun serialize(encoder: Encoder, value: Matrix) {
                    val include = listOfNotNull(value.include?.let {
                        Pair<String, JsonElement>(
                            INCLUDE_FIELD_NAME,
                            JsonArray(it.map { e -> JsonObject(e.mapValues { (_, v) -> JsonPrimitive(v) }) }),
                        )
                    })

                    val dimensions = value.dimensions.map { (k, v) ->
                        Pair<String, JsonElement>(k, JsonArray(v.map { JsonPrimitive(it) }))
                    }

                    mapSerializer.serialize(encoder, (include + dimensions).toMap())
                }

                override fun deserialize(decoder: Decoder): Matrix {
                    val map = mapSerializer.deserialize(decoder).toMutableMap()
                    val include = map.remove(INCLUDE_FIELD_NAME)

                    return Matrix(
                        dimensions = map.mapValues { (_, v) -> (v as JsonArray).map { (it as JsonPrimitive).content } },
                        include = (include as JsonArray).map {
                            (it as JsonObject).mapValues { entry -> (entry.value as JsonPrimitive).content }
                        }
                    )
                }
            }
        }
    }

    @Serializable
    data class Container(
        val image: String? = null,
        val credentials: Credentials? = null,
        val env: Map<String, String>? = null,
        val ports: List<Int>? = null,
        val volumes: List<String>? = null,
        val options: List<String>? = null,
    ) {
        @Serializable
        data class Credentials(
            val username: String? = null,
            val password: String? = null,
        )
    }
}
