package jp.s6n.idea.ghactions.schema.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.JsonNamingStrategy

/**
 * sourceCodeOf(JsonNamingStrategy.SnakeCase).replaceAll('_', '-')
 */
@OptIn(ExperimentalSerializationApi::class)
object KebabCaseNamingStrategy : JsonNamingStrategy {
    override fun serialNameForJson(descriptor: SerialDescriptor, elementIndex: Int, serialName: String): String =
        buildString(serialName.length * 2) {
            var bufferedChar: Char? = null
            var previousUpperCharsCount = 0

            serialName.forEach { c ->
                if (c.isUpperCase()) {
                    if (previousUpperCharsCount == 0 && isNotEmpty() && last() != '-')
                        append('-')

                    bufferedChar?.let(::append)

                    previousUpperCharsCount++
                    bufferedChar = c.lowercaseChar()
                } else {
                    if (bufferedChar != null) {
                        if (previousUpperCharsCount > 1 && c.isLetter()) {
                            append('-')
                        }
                        append(bufferedChar)
                        previousUpperCharsCount = 0
                        bufferedChar = null
                    }
                    append(c)
                }
            }

            if (bufferedChar != null) {
                append(bufferedChar)
            }
        }
}
