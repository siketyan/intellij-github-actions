package jp.s6n.idea.ghactions.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class PluginSettings : Configurable, Configurable.Composite {
    override fun createComponent(): JComponent? {
        return null
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {
    }

    override fun getDisplayName(): String  = "GitHub Actions Support"

    override fun getConfigurables(): Array<Configurable> {
        return arrayOf(
            ActionLintSettings(),
        )
    }
}
