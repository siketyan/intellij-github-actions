package jp.s6n.idea.ghactions.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Permissions(
    val actions: Permission? = null,
    val checks: Permission? = null,
    val contents: Permission? = null,
    val deployments: Permission? = null,
    val discussions: Permission? = null,
    val idToken: Permission? = null,
    val issues: Permission? = null,
    val packages: Permission? = null,
    val pages: Permission? = null,
    val pullRequests: Permission? = null,
    val repositoryProjects: Permission? = null,
    val securityEvents: Permission? = null,
    val statuses: Permission? = null,
) {
    @Serializable
    enum class Permission {
        @SerialName("read")
        READ,

        @SerialName("write")
        WRITE,

        @SerialName("none")
        NONE,
    }
}
