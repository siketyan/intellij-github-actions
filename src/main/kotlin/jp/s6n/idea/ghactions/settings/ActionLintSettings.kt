package jp.s6n.idea.ghactions.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Storage
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.util.ui.FormBuilder
import com.intellij.util.xmlb.XmlSerializerUtil
import javax.swing.JPanel

class ActionLintSettings : Configurable {
    @com.intellij.openapi.components.State(
        name = "jp.s6n.idea.ghactions.settings.ActionLintSettings\$State",
        storages = [Storage("GitHubActionsSupport_ActionLint.xml")],
    )
    class State : PersistentStateComponent<State> {
        var actionlintPath: String = "actionlint"

        override fun getState(): State = this

        override fun loadState(state: State) {
            XmlSerializerUtil.copyBean(state, this)
        }

        companion object {
            fun getInstance(): State =
                ApplicationManager.getApplication().getService(State::class.java)
        }
    }

    private lateinit var actionlintPathField: TextFieldWithBrowseButton

    override fun createComponent(): JPanel {
        actionlintPathField = TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(
                "Path to Actionlint Executable", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor(),
            )
        }

        return FormBuilder.createFormBuilder()
            .addLabeledComponent("Path to actionlint executable", actionlintPathField)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    override fun isModified(): Boolean =
        State.getInstance().actionlintPath != actionlintPathField.text

    override fun apply() {
        State.getInstance().actionlintPath = actionlintPathField.text
    }

    override fun reset() {
        actionlintPathField.text = State.getInstance().actionlintPath
    }

    @Suppress("DialogTitleCapitalization")
    override fun getDisplayName(): String = "actionlint"
}
