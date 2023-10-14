package jp.s6n.idea.ghactions.lang.highlighting

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import jp.s6n.idea.ghactions.lang.WorkflowInlineLexerAdapter
import jp.s6n.idea.ghactions.lang.WorkflowInlineTypes

class WISyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = WorkflowInlineLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey?> {
        if (tokenType === null) return EMPTY_KEYS

        return when (tokenType) {
            WorkflowInlineTypes.CONDITION_OPERATOR,
            WorkflowInlineTypes.OP_NOT,
            WorkflowInlineTypes.OP_DOT -> OPERATOR_KEYS

            WorkflowInlineTypes.NULL,
            WorkflowInlineTypes.TRUE,
            WorkflowInlineTypes.FALSE -> KEYWORD_KEYS

            WorkflowInlineTypes.NUMBER_LITERAL -> NUMBER_KEYS
            WorkflowInlineTypes.STRING_LITERAL -> STRING_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHARACTER_KEYS

            else -> EMPTY_KEYS
        }
    }

    companion object {
        private val OPERATOR_KEYS = arrayOf<TextAttributesKey?>(
            createTextAttributesKey("WI_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN),
        )

        private val KEYWORD_KEYS = arrayOf<TextAttributesKey?>(
            createTextAttributesKey("WI_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD),
        )

        private val NUMBER_KEYS = arrayOf<TextAttributesKey?>(
            createTextAttributesKey("WI_NUMBER", DefaultLanguageHighlighterColors.NUMBER),
        )

        private val STRING_KEYS = arrayOf<TextAttributesKey?>(
            createTextAttributesKey("WI_STRING", DefaultLanguageHighlighterColors.STRING),
        )

        private val BAD_CHARACTER_KEYS = arrayOf<TextAttributesKey?>(
            createTextAttributesKey("WI_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER),
        )

        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey?>(0)
    }
}
