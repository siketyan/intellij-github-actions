package jp.s6n.idea.ghactions.lang

import com.intellij.lang.Language

class WorkflowInlineLanguage : Language("GitHubWorkflowInline") {
    companion object {
        val INSTANCE = WorkflowInlineLanguage()
    }
}
