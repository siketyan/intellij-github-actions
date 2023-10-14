package jp.s6n.idea.ghactions.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import jp.s6n.idea.ghactions.lang.WorkflowInlineFileType
import jp.s6n.idea.ghactions.lang.WorkflowInlineLanguage

class WIFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, WorkflowInlineLanguage.INSTANCE) {
    override fun getFileType(): FileType = WorkflowInlineFileType.INSTANCE
}
