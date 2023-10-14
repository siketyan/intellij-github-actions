package jp.s6n.idea.ghactions.execution.runner.act

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import jp.s6n.idea.ghactions.execution.JobRunConfiguration
import jp.s6n.idea.ghactions.execution.runner.Runner
import jp.s6n.idea.ghactions.settings.ActSettings

class ActRunner : Runner {
    override fun run(options: JobRunConfiguration.Options): ProcessHandler =
        ProcessHandlerFactory
            .getInstance()
            .createColoredProcessHandler(
                GeneralCommandLine(
                    ActSettings.State.getInstance().actPath,
                    "-W", options.workflowPath,
                    "-j", options.jobName,
                )
                    .withWorkDirectory(options.workingDirectory)
            )
            .also {
                ProcessTerminatedListener.attach(it)
            }
}
