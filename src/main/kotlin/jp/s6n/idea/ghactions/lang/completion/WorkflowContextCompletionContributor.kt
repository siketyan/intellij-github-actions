package jp.s6n.idea.ghactions.lang.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.findTopmostParentOfType
import com.intellij.util.ProcessingContext
import jp.s6n.idea.ghactions.context.Object
import jp.s6n.idea.ghactions.context.Property
import jp.s6n.idea.ghactions.context.RootObject
import jp.s6n.idea.ghactions.lang.WorkflowInlineTypes
import jp.s6n.idea.ghactions.lang.psi.WIQualifier

class WorkflowContextCompletionContributor : CompletionContributor() {
    private val provider = object : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            var parent: Object = RootObject.INSTANCE
            var qualifier = parameters.position.findTopmostParentOfType<WIQualifier>() ?: return

            while (true) {
                val item = parent.find(qualifier.ident.text) as? Object ?: break

                if (qualifier.qualifier?.text != "IntellijIdeaRulezzz") {
                    qualifier = qualifier.qualifier ?: break
                    parent = item

                    continue
                }

                item.children().forEach {
                    if (it !is Property) return@forEach

                    result.addElement(
                        LookupElementBuilder
                            .create(it.name)
                            .withIcon(AllIcons.Nodes.Field)
                            .withTypeText(it.type.toString())
                            .withTailText(it.summary)
                    )
                }

                break
            }
        }
    }

    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(WorkflowInlineTypes.ID), provider)
    }
}
