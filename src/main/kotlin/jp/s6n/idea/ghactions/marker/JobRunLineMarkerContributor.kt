package jp.s6n.idea.ghactions.marker

import com.intellij.execution.actions.RunContextAction
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLKeyValue

class JobRunLineMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (!WorkflowFileMatcher.match(element.containingFile)) return null

        val parent = element.parent
        if (parent !is YAMLKeyValue || parent.key != element) return null

        val path = YAMLUtil.getConfigFullNameParts(parent)
        if (path.count() != 2) return null
        if (path[0] != "jobs") return null

        return Info(
            AllIcons.RunConfigurations.TestState.Run,
            arrayOf(RunContextAction(DefaultRunExecutor.getRunExecutorInstance())),
        ) {
            "Run job"
        }
    }
}
