package jp.s6n.idea.ghactions.schema

import jp.s6n.idea.ghactions.schema.serialization.KebabCaseNamingStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlin.test.*

class JobTest {
    @OptIn(ExperimentalSerializationApi::class)
    private val decoder = Json {
        ignoreUnknownKeys = true
        isLenient = true
        namingStrategy = KebabCaseNamingStrategy
    }

    @Test
    fun deserializeMatrix() {
        val matrix = decoder.decodeFromString<Job.Strategy.Matrix>("""
            {
              "foo": ["bar", "baz", "qux"],
              "include": [
                {
                  "foo": "bar",
                  "test": true
                }
              ]
            }
        """.trimIndent())

        assertSame(1, matrix.dimensions.count())
        assertEquals(listOf("bar", "baz", "qux"), matrix.dimensions["foo"])

        assertSame(1, matrix.include?.count())
        assertEquals("bar", matrix.include?.first()?.get("foo"))
        assertEquals("true", matrix.include?.first()?.get("test"))
    }
}
