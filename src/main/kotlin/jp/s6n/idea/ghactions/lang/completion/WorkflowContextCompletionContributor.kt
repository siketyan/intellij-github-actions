package jp.s6n.idea.ghactions.lang.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.PsiEditorUtil
import com.intellij.psi.util.findParentOfType
import com.intellij.psi.util.findTopmostParentOfType
import com.intellij.util.ProcessingContext
import jp.s6n.idea.ghactions.context.Object
import jp.s6n.idea.ghactions.context.RootObject
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import jp.s6n.idea.ghactions.lang.WorkflowInlineTypes
import jp.s6n.idea.ghactions.lang.psi.WIQualifier
import jp.s6n.idea.ghactions.schema.Workflow
import kotlinx.serialization.SerializationException
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLPsiElement
import org.yaml.snakeyaml.error.YAMLException

class WorkflowContextCompletionContributor : CompletionContributor() {
    private val provider = object : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            val file = parameters.editor.virtualFile
            if (!WorkflowFileMatcher.match(file)) return

            val editor = FileEditorManager.getInstance(parameters.editor.project!!).selectedTextEditor!!
            val jobName =
                PsiEditorUtil
                    .getPsiFile(editor)
                    .findElementAt(editor.caretModel.offset)
                    ?.findParentOfType<YAMLPsiElement>()
                    ?.let {
                        val path = YAMLUtil.getConfigFullNameParts(it)
                        when (path.firstOrNull()) {
                            "jobs" -> path.getOrNull(1)
                            else -> null
                        }
                    }

            val workflow = try {
                Workflow.fromYaml(file.inputStream)
            } catch (e: SerializationException) {
                return Logger.getInstance(this.javaClass).warn(e)
            } catch (e: YAMLException) {
                return Logger.getInstance(this.javaClass).warn(e)
            }

            var parent: Object = RootObject(workflow, jobName)
            var qualifier = parameters.position.findTopmostParentOfType<WIQualifier>() ?: return

            while (qualifier.qualifiable.ident?.text?.endsWith("IntellijIdeaRulezzz") == false) {
                parent = parent.find(qualifier.qualifiable.ident!!.text) as? Object ?: return
                qualifier = qualifier.qualifier ?: return
            }

            parent.children().forEach { (name, item) ->
                result.addElement(
                    LookupElementBuilder
                        .create(name)
                        .withIcon(AllIcons.Nodes.Field)
                        .withTypeText(item.type().toString())
                        .withTailText(item.summary())
                )
            }
        }
    }

    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(WorkflowInlineTypes.ID), provider)
    }
}
