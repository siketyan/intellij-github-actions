package jp.s6n.idea.ghactions.injection

import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import jp.s6n.idea.ghactions.lang.WorkflowInlineLanguage
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLScalar

class ContextualExpressionInjector : LanguageInjectionContributor
{
    override fun getInjection(context: PsiElement): Injection? {
        if (!WorkflowFileMatcher.match(context.containingFile)) return null
        if (context !is YAMLScalar) return null
        if (context.textMatches("\${{")) return null // Prefer inline expressions

        val path = YAMLUtil.getConfigFullNameParts(context)
        if (path.firstOrNull() != "jobs") return null
        when (path.count()) {
            3 -> when {
                path[2] == "if" -> Unit
                else -> return null
            }
            4 -> when {
                path[2] == "outputs" -> Unit
                path[3] == "if" -> Unit
                else -> return null
            }
            else -> return null
        }

        return SimpleInjection(WorkflowInlineLanguage.INSTANCE, "", "",  null)
    }
}
