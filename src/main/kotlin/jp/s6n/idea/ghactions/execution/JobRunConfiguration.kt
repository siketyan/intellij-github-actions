package jp.s6n.idea.ghactions.execution

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import jp.s6n.idea.ghactions.execution.runner.act.ActRunner

class JobRunConfiguration(project: Project, factory: JobRunConfigurationFactory, name: String)
    : RunConfigurationBase<JobRunConfiguration.Options>(project, factory, name) {
    val allOptions: Options get() = options

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
        return object : CommandLineState(environment) {
            override fun startProcess(): ProcessHandler = ActRunner().run(options)
        }
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = JobRunConfigurationEditor()
    override fun getOptions(): Options = super.getOptions() as Options

    class Options : RunConfigurationOptions() {
        var workingDirectory = ""
        var workflowPath = ""
        var jobName = ""
    }
}
