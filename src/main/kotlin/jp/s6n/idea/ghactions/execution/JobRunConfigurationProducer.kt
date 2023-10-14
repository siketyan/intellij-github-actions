package jp.s6n.idea.ghactions.execution

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import org.jetbrains.yaml.psi.YAMLKeyValue

class JobRunConfigurationProducer : LazyRunConfigurationProducer<JobRunConfiguration>() {
    override fun getConfigurationFactory(): ConfigurationFactory =
        JobRunConfigurationFactory(JobRunConfigurationType())

    override fun setupConfigurationFromContext(
        configuration: JobRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>,
    ): Boolean {
        val file = context.psiLocation?.containingFile ?: return false

        configuration.allOptions.workingDirectory =
            file.virtualFile.findFileByRelativePath("../../..")?.path ?: return false

        configuration.allOptions.workflowPath = file.virtualFile.path

        (sourceElement.get().parent as? YAMLKeyValue)?.let {
            configuration.name = it.keyText
            configuration.allOptions.jobName = it.keyText
        }

        return true
    }

    override fun isConfigurationFromContext(
        configuration: JobRunConfiguration,
        context: ConfigurationContext,
    ): Boolean =
        context.psiLocation?.containingFile?.let { WorkflowFileMatcher.match(it) } ?: false
}
