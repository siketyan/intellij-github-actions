package jp.s6n.idea.ghactions.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import jp.s6n.idea.ghactions.lang.psi.WIFile

class WorkflowInlineParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = WorkflowInlineLexerAdapter()

    override fun createParser(project: Project?): PsiParser = WorkflowInlineParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY

    override fun getStringLiteralElements(): TokenSet = WorkflowInlineTokenSets.STRING_LITERALS

    override fun createElement(node: ASTNode?): PsiElement = WorkflowInlineTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = WIFile(viewProvider)

    companion object {
        val FILE = IFileElementType(WorkflowInlineLanguage.INSTANCE)
    }
}
