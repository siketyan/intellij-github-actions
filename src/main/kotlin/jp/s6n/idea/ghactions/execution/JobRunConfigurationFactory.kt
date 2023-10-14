package jp.s6n.idea.ghactions.execution

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.project.Project

class JobRunConfigurationFactory(ty: JobRunConfigurationType) : ConfigurationFactory(ty) {
    override fun createTemplateConfiguration(project: Project): JobRunConfiguration =
        JobRunConfiguration(project, this, "GitHub Workflow Job")

    override fun getId(): String = JobRunConfigurationType.ID
    override fun getOptionsClass(): Class<JobRunConfiguration.Options> = JobRunConfiguration.Options::class.java
}
