package jp.s6n.idea.ghactions.lang

import com.intellij.psi.tree.IElementType

class WorkflowInlineTokenType(debugName: String) : IElementType(debugName, WorkflowInlineLanguage.INSTANCE) {
    override fun toString(): String = "WorkflowInlineTokenType.${super.toString()}"
}
