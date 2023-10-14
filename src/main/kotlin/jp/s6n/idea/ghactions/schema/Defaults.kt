package jp.s6n.idea.ghactions.schema

import kotlinx.serialization.Serializable

@Serializable
data class Defaults(
    val run: Run? = null,
) {
    @Serializable
    data class Run(
        val shell: String? = null,
        val workingDirectory: String? = null,
    )
}
