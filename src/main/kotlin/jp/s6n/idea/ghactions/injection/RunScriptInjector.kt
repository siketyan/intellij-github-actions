package jp.s6n.idea.ghactions.injection

import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import com.intellij.sh.ShLanguage
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import org.jetbrains.yaml.YAMLUtil
import org.jetbrains.yaml.psi.YAMLScalar

class RunScriptInjector : LanguageInjectionContributor
{
    override fun getInjection(context: PsiElement): Injection? {
        if (!WorkflowFileMatcher.match(context.containingFile)) return null
        if (context !is YAMLScalar) return null

        val path = YAMLUtil.getConfigFullNameParts(context)
        if (path.count() < 4) return null
        if (path[0] != "jobs") return null
        if (!path[2].matches(Regex("""^steps\[\d+]$"""))) return null
        if (path[3] != "run") return null

        return SimpleInjection(ShLanguage.INSTANCE, "", "",  null)
    }
}
