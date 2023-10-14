package jp.s6n.idea.ghactions.injection

import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import jp.s6n.idea.ghactions.lang.WorkflowInlineLanguage
import org.jetbrains.yaml.psi.YAMLScalar

class InlineExpressionInjector : MultiHostInjector {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement
    ) {
        if (context !is YAMLScalar) return

        val start = context.text.indexOf("\${{")+3
        val end = context.text.indexOf("}}", start)
        if (start < 0 || end < 0) return

        registrar
            .startInjecting(WorkflowInlineLanguage.INSTANCE)
            .addPlace(null, null, context, TextRange.create(start, end))
            .doneInjecting()
    }

    override fun elementsToInjectIn(): List<Class<YAMLScalar>> {
        return listOf(YAMLScalar::class.java)
    }
}
