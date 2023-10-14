package jp.s6n.idea.ghactions.marker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parentOfType
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLDocument
import org.jetbrains.yaml.psi.YAMLScalar

class NeedsLineMarkerProvider : RelatedItemLineMarkerProvider() {
    override fun collectNavigationMarkers(
        element: PsiElement,
        result: MutableCollection<in RelatedItemLineMarkerInfo<*>>
    ) {
        if (!WorkflowFileMatcher.match(element.containingFile)) return
        if (element !is YAMLScalar) return

        val path = YAMLUtil.getConfigFullNameParts(element)
        if (path.count() < 3 || path[0] != "jobs" || path[2] != "needs") return

        val document = element.parentOfType<YAMLDocument>() ?: return
        val target = YAMLUtil.getQualifiedKeyInDocument(document, listOf("jobs", element.textValue))?.key ?: return

        result.add(
            NavigationGutterIconBuilder.create(AllIcons.Gutter.WriteAccess)
                .setTargets(target)
                .setTooltipText("Navigate to job declaration")
                .createLineMarkerInfo(element.firstChild)
        )

        result.add(
            NavigationGutterIconBuilder.create(AllIcons.Gutter.ReadAccess)
                .setTargets(element.firstChild)
                .setTooltipText("Navigate to usages")
                .createLineMarkerInfo(target)
        )
    }
}
