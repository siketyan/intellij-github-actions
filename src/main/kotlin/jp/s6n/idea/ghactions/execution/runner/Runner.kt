package jp.s6n.idea.ghactions.execution.runner

import com.intellij.execution.process.ProcessHandler
import jp.s6n.idea.ghactions.execution.JobRunConfiguration

interface Runner {
    fun run(options: JobRunConfiguration.Options): ProcessHandler
}
