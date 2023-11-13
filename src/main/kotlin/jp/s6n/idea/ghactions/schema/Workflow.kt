package jp.s6n.idea.ghactions.schema

import com.fasterxml.jackson.databind.ObjectMapper
import jp.s6n.idea.ghactions.schema.serialization.KebabCaseNamingStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.yaml.snakeyaml.Yaml
import java.io.InputStream

@Serializable
data class Workflow(
    val name: String? = null,
    val runName: String? = null,
    val permissions: Permissions? = null,
    val env: Map<String, String>? = null,
    val defaults: Defaults? = null,
    @Serializable(with = Concurrency.Serializer::class)
    val concurrency: Concurrency? = null,
    val jobs: Map<String, Job>? = null,
) {
    @OptIn(ExperimentalSerializationApi::class)
    companion object {
        private val decoder = Json {
            ignoreUnknownKeys = true
            isLenient = true
            namingStrategy = KebabCaseNamingStrategy
        }

        fun fromYaml(stream: InputStream) =
            decoder.decodeFromString<Workflow>(
                ObjectMapper().writeValueAsString(
                    Yaml().load<Map<String, Any>>(stream.readAllBytes().decodeToString()),
                ),
            )
    }
}
