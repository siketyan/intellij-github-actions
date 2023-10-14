package jp.s6n.idea.ghactions.lang

import com.intellij.psi.tree.IElementType

class WorkflowInlineElementType(debugName: String) : IElementType(debugName, WorkflowInlineLanguage.INSTANCE) {
    override fun toString(): String = "WorkflowInlineElementType.${super.toString()}"
}
