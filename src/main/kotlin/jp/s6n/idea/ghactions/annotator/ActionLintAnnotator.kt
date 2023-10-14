package jp.s6n.idea.ghactions.annotator

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import jp.s6n.idea.ghactions.annotator.actionlint.Violation
import jp.s6n.idea.ghactions.fs.WorkflowFileMatcher
import jp.s6n.idea.ghactions.settings.ActionLintSettings
import java.io.File
import kotlin.io.path.pathString

class ActionLintAnnotator : ExternalAnnotator<ActionLintAnnotator.InitialInfo, ActionLintAnnotator.Result>() {
    data class InitialInfo(
        val workingDirectory: String,
        val filename: String,
    )

    data class Result(
        val violations: List<Violation>,
    )

    override fun collectInformation(file: PsiFile): InitialInfo? {
        if (!WorkflowFileMatcher.match(file)) return null

        return InitialInfo(
            workingDirectory = file.virtualFile.toNioPath().parent.pathString,
            filename = file.virtualFile.name,
        )
    }

    override fun doAnnotate(collectedInfo: InitialInfo?): Result? {
        if (collectedInfo == null) return null

        val process = ProcessBuilder(
            listOf(
                ActionLintSettings.State.getInstance().actionlintPath,
                "-format", "{{json .}}",
                collectedInfo.filename,
            ),
        )
            .apply {
                directory(File(collectedInfo.workingDirectory))
            }
            .start()
            .apply { waitFor() }

        return Result(
            violations = Violation.fromJson(process.inputStream),
        )
    }

    override fun apply(file: PsiFile, annotationResult: Result?, holder: AnnotationHolder) {
        if (annotationResult == null) return

        val document = PsiDocumentManager.getInstance(file.project).getDocument(file) ?: return

        annotationResult.violations.forEach {
            holder
                .newAnnotation(HighlightSeverity.ERROR, "${it.kind}: ${it.message}")
                .highlightType(ProblemHighlightType.GENERIC_ERROR)
                .range(
                    TextRange.from(
                        document.getLineStartOffset(it.line - 1) + it.column - 1,
                        it.endColumn - it.column,
                    )
                )
                .create()
        }
    }
}
