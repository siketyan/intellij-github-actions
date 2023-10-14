package jp.s6n.idea.ghactions.lang

import com.intellij.psi.tree.TokenSet

object WorkflowInlineTokenSets {
    val IDENTIFIERS = TokenSet.create(WorkflowInlineTypes.ID)

    var STRING_LITERALS = TokenSet.create(WorkflowInlineTypes.STRING_LITERAL)
}
