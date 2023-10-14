package jp.s6n.idea.ghactions.execution

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class JobRunConfigurationEditor : SettingsEditor<JobRunConfiguration>() {
    private var workingDirectoryField: TextFieldWithBrowseButton? = null
    private var workflowPathField: TextFieldWithBrowseButton? = null
    private var jobNameField: JBTextField? = null

    private lateinit var myPanel: JPanel

    init {
        workingDirectoryField = TextFieldWithBrowseButton().also {
            it.addBrowseFolderListener("Working Directory", null, null,
                FileChooserDescriptorFactory.createSingleFolderDescriptor())
        }

        workflowPathField = TextFieldWithBrowseButton().also {
            it.addBrowseFolderListener("Workflow Path", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor())
        }

        jobNameField = JBTextField()

        FormBuilder.createFormBuilder()
            .addLabeledComponent("Working directory", workingDirectoryField!!)
            .addLabeledComponent("Workflow path", workflowPathField!!)
            .addLabeledComponent("Job name", jobNameField!!)
            .panel
    }

    override fun resetEditorFrom(s: JobRunConfiguration) =
        s.allOptions.let {
            workingDirectoryField?.text = s.allOptions.workingDirectory
            workflowPathField?.text = s.allOptions.workflowPath
            jobNameField?.text = s.allOptions.jobName
        }

    override fun applyEditorTo(s: JobRunConfiguration) =
        s.allOptions.let {
            it.workingDirectory = workingDirectoryField?.text ?: ""
            it.workflowPath = workflowPathField?.text ?: ""
            it.jobName = jobNameField?.name ?: ""
        }

    override fun createEditor(): JComponent = myPanel
}
