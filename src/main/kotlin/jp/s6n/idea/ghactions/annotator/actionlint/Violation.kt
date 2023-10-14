package jp.s6n.idea.ghactions.annotator.actionlint

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import kotlinx.serialization.json.decodeFromStream
import java.io.InputStream

@Serializable
data class Violation(
    val message: String,
    val filepath: String,
    val line: Int,
    val column: Int,
    val kind: String,
    val snippet: String,
    val endColumn: Int,
) {
    @OptIn(ExperimentalSerializationApi::class)
    companion object {
        private val decoder = Json {
            namingStrategy = JsonNamingStrategy.SnakeCase
        }

        fun fromJson(stream: InputStream) = decoder.decodeFromStream<List<Violation>>(stream)
    }
}
