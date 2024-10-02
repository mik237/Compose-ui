package me.ibrahim.composepractice.testing_practice.utils

import me.ibrahim.composepractice.BuildConfig

object HomeWorkUtil {
    /**
     * Returns the n-th fibonacci number
     * They are defined like this:
     * fib(0) = 0
     * fib(1) = 1
     * fib(2) = 1
     * fib(3) = 2
     * fib(4) = 3
     * fib(n) = fib(n-2) + fib(n-1)
     */
    fun fib(n: Int): Long {
        if (n == 0 || n == 1) {
            return n.toLong()
        }
        var a = 0L
        var b = 1L
        var c = 1L
        (2..n).forEach { i ->
            c = a + b
            a = b
            b = c
        }
        return c
    }

    /**
     * Checks if the braces are set correctly
     * e.g. "(a * b))" should return false
     */
    fun checkBraces(string: String): Boolean {

        /*val firstOpeningBraceIndex = string.indexOfFirst { it == '(' }
        val firstClosingBraceIndex = string.indexOfFirst { it == ')' }

        if (firstClosingBraceIndex < firstOpeningBraceIndex)
            return false

        return string.count { it == '(' } == string.count { it == ')' }*/

        var balance = 0

        for (c in string) {
            if (c == '(') balance++
            else if (c == ')') balance--

            if (balance < 0) break
        }

        return balance == 0
    }
}