package org.alexside.examples.kotlin.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KotlinLangTest {
    @Test
    fun variableAssignTest() {
        val intVal = 5
        assertEquals(5, intVal)
        var intVar = 10
        assertEquals(10, intVar)
        intVar = 100;
        assertEquals(100, intVar)
    }

    @Test
    fun collectionToJSONTest() {
        val collection = listOf(1, 2, 3, 4, 5)
        val json = toJSON(collection)
        assertEquals("[1,2,3,4,5]", json)
    }

    @Test
    fun namedArgumentsTest() {
        assertEquals("prefix,postfix", joinToString(prefix = "prefix", postfix="postfix"))
        assertEquals("prefix:postfix", joinToString(separator = ":", prefix = "prefix", postfix="postfix"))
        assertEquals("prefix:postfix", joinToString(":", "prefix", "postfix"))
        assertEquals("[a, b, c, d, e, f]", joinOptions(listOf("a", "b", "c", "d", "e", "f")))
    }

    @Test
    fun defaultArgumentsTest() {
        val list = listOf(
                foo("a"),
                foo("b", number = 1),
                foo("c", toUpperCase = true),
                foo(name = "d", number = 2, toUpperCase = true)
        )
        assertEquals(listOf("a42", "b1", "C42", "D2"), list)
    }

    @Test
    fun containsEvenTest() {
        assertTrue(containsEven(listOf(44, 21)))
        assertFalse(containsEven(listOf(1, 3, 5, 7, 9)))
    }

    companion object { // static method
        fun toJSON(collection: Collection<Int>) : String {
            val sb = StringBuilder()
            sb.append("[")
            val iterator = collection.iterator();
            while (iterator.hasNext()) {
                val element = iterator.next()
                sb.append(element)
                if (iterator.hasNext()) {
                    sb.append(",")
                }
            }
            sb.append("]")
            return sb.toString()
        }
    }

    fun joinToString(
            separator: String = ",",
            prefix: String = "",
            postfix: String = "",
    ) = StringBuilder(prefix).append(separator).append(postfix).toString()


    fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")

    fun foo(name : String, number :Int = 42, toUpperCase :Boolean = false) =
            (if (toUpperCase) name.toUpperCase() else name) + number

    fun containsEven(collection: Collection<Int>) :Boolean = collection.any { it % 2 == 0 }
}