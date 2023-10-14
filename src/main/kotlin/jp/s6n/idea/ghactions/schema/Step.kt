package jp.s6n.idea.ghactions.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Step(
    val id: String? = null,
    @SerialName("if")
    val runsIf: String? = null,
    val name: String? = null,
    val uses: String? = null,
    val run: String? = null,
    val workingDirectory: String? = null,
    val shell: String? = null,
    val with: Map<String, String>? = null,
    val env: Map<String, String>? = null,
    val continueOnError: Boolean? = null,
    val timeoutMinutes: Int? = null,
)
