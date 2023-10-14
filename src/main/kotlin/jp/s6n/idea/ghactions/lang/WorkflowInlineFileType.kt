package jp.s6n.idea.ghactions.lang

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class WorkflowInlineFileType : LanguageFileType(WorkflowInlineLanguage.INSTANCE) {
    override fun getName(): String = "GitHub Workflow Expression"
    override fun getDescription(): String = "GitHub Workflow Expression"
    override fun getDefaultExtension(): String = ""
    override fun getIcon(): Icon = AllIcons.FileTypes.Yaml

    companion object {
        val INSTANCE = WorkflowInlineFileType()
    }
}
