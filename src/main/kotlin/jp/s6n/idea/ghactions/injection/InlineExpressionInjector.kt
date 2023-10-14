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

        var offset = 0
        while (true) {
            val start = context.text.indexOf(INLINE_EXPR_START, offset)
            val end = context.text.indexOf(INLINE_EXPR_END, start)
            if (start < 0 || end < 0) break

            registrar
                .startInjecting(WorkflowInlineLanguage.INSTANCE)
                .addPlace("", "", context, TextRange.create(start + INLINE_EXPR_START.length, end))
                .doneInjecting()

            offset = end
        }
    }

    override fun elementsToInjectIn(): List<Class<YAMLScalar>> {
        return listOf(YAMLScalar::class.java)
    }

    companion object {
        private const val INLINE_EXPR_START = "\${{"
        private const val INLINE_EXPR_END = "}}"
    }
}
