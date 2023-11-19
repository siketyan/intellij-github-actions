package jp.s6n.idea.ghactions.injection

import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import jp.s6n.idea.ghactions.lang.WorkflowInlineLanguage
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLScalar

class IfExpressionInjector : MultiHostInjector {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement
    ) {
        if (!WorkflowFileMatcher.match(context.containingFile)) return
        if (context !is YAMLScalar) return

        val path = YAMLUtil.getConfigFullNameParts(context)
        if (path.count() < 3) return
        if (path.last() != "if") return

        registrar
            .startInjecting(WorkflowInlineLanguage.INSTANCE)
            .addPlace("", "", context, TextRange.create(0, context.text.length))
            .doneInjecting()
    }

    override fun elementsToInjectIn(): List<Class<YAMLScalar>> {
        return listOf(YAMLScalar::class.java)
    }
}
