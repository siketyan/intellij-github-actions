package jp.s6n.idea.ghactions.schema

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import com.charleskorn.kaml.YamlNamingStrategy
import com.charleskorn.kaml.decodeFromStream
import kotlinx.serialization.Serializable
import java.io.InputStream

@Serializable
data class Workflow(
    val name: String? = null,
    val runName: String? = null,
    val permissions: Permissions? = null,
    val env: Map<String, String>? = null,
    val defaults: Defaults? = null,
    val concurrency: Concurrency? = null,
    val jobs: List<Job>? = null,
) {
    companion object {
        private val decoder = Yaml(configuration = YamlConfiguration(
            encodeDefaults = false,
            strictMode = false,
            yamlNamingStrategy = YamlNamingStrategy.KebabCase,
        ))

        fun fromYaml(stream: InputStream) = decoder.decodeFromStream<Workflow>(stream)
    }
}
