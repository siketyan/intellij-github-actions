package jp.s6n.idea.ghactions.marker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parentOfType
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import jp.s6n.idea.ghactions.schema.Workflow
import kotlinx.serialization.SerializationException
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLDocument
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.yaml.snakeyaml.error.YAMLException

class NeedsUsagesLineMarkerProvider : RelatedItemLineMarkerProvider() {
    override fun collectNavigationMarkers(
        element: PsiElement,
        result: MutableCollection<in RelatedItemLineMarkerInfo<*>>,
    ) {
        if (!WorkflowFileMatcher.match(element.containingFile)) return
        if (element !is YAMLKeyValue) return

        val path = YAMLUtil.getConfigFullNameParts(element)
        if (path.count() != 2 || path[0] != "jobs") return

        val workflow: Workflow
        try {
            workflow = Workflow.fromYaml(element.containingFile.virtualFile.inputStream)
        } catch (e: SerializationException) {
            return Logger.getInstance(this.javaClass).warn(e)
        } catch (e: YAMLException) {
            return Logger.getInstance(this.javaClass).warn(e)
        }

        val jobName = path[1]
        val usages = (workflow.jobs ?: mapOf())
            .filterValues { it.needs?.contains(jobName) ?: false }
            .map { it.key }

        if (usages.isEmpty()) return

        val document = element.parentOfType<YAMLDocument>() ?: return
        val targets = usages.map {
            YAMLUtil.getQualifiedKeyInDocument(document, listOf("jobs", it))?.key!!
        }

        result.add(
            NavigationGutterIconBuilder.create(AllIcons.Gutter.ReadAccess)
                .setTargets(targets)
                .setTooltipText("Navigate to job usages")
                .createLineMarkerInfo(element.key!!)
        )
    }
}
