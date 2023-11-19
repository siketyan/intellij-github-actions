package jp.s6n.idea.ghactions.fs

import com.intellij.psi.PsiFile

object WorkflowFileMatcher {
    private val reWorkflowPath = Regex("""^.+/\.github/workflows/.+\.ya?ml$""")

    private fun match(path: String) =
        path.matches(reWorkflowPath)

    fun match(file: PsiFile) =
        file.virtualFile?.let { match(it.path) } ?: true
}
