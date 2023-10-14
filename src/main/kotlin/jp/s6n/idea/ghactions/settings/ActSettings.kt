package jp.s6n.idea.ghactions.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.State as AsState
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.util.ui.FormBuilder
import com.intellij.util.xmlb.XmlSerializerUtil
import javax.swing.JPanel

class ActSettings : Configurable {
    @AsState(
        name = "jp.s6n.idea.ghactions.settings.ActSettings\$State",
        storages = [Storage("GitHubActionsSupport_Act.xml")],
    )
    class State : PersistentStateComponent<State> {
        var actPath: String = "act"

        override fun getState(): State = this

        override fun loadState(state: State) {
            XmlSerializerUtil.copyBean(state, this)
        }

        companion object {
            fun getInstance(): State =
                ApplicationManager.getApplication().getService(State::class.java)
        }
    }

    private lateinit var actPathField: TextFieldWithBrowseButton

    override fun createComponent(): JPanel {
        actPathField = TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(
                "Path to Act Executable", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor(),
            )
        }

        return FormBuilder.createFormBuilder()
            .addLabeledComponent("Path to act executable", actPathField)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    override fun isModified(): Boolean =
        State.getInstance().actPath != actPathField.text

    override fun apply() {
        State.getInstance().actPath = actPathField.text
    }

    override fun reset() {
        actPathField.text = State.getInstance().actPath
    }

    @Suppress("DialogTitleCapitalization")
    override fun getDisplayName(): String = "act"
}
