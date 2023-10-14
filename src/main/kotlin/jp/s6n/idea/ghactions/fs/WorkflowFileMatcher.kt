package jp.s6n.idea.ghactions.fs

import com.intellij.psi.PsiFile

object WorkflowFileMatcher {
    private val reWorkflowPath = Regex("""^.+/\.github/workflows/.+\.yaml$""")

    fun match(path: String) =
        path.matches(reWorkflowPath)

    fun match(file: PsiFile) =
        match(file.virtualFile.path)
}
