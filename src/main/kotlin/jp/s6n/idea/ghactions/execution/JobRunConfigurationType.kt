package jp.s6n.idea.ghactions.execution

import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.icons.AllIcons

class JobRunConfigurationType : ConfigurationTypeBase(
    ID,
    "GitHub Workflow Job",
    "Runs a workflow job on a local runner.",
    AllIcons.Nodes.Console,
) {
    init {
        addFactory(JobRunConfigurationFactory(this))
    }

    companion object {
        const val ID = "GitHubWorkflowJobRunConfiguration"
    }
}
