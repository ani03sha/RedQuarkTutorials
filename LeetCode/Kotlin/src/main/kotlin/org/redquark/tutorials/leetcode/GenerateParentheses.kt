package org.redquark.tutorials.leetcode

fun generateParenthesis(n: Int): List<String> {
    // Resultant list
    val result: MutableList<String> = ArrayList()
    /// Recursively generate parentheses
    generateParenthesis(result, "", 0, 0, n)
    return result
}

fun generateParenthesis(result: MutableList<String>, s: String, open: Int, close: Int, n: Int) {
    // Base case
    if (open == n && close == n) {
        result.add(s)
        return
    }
    // If the number of open parentheses is less than the given n
    if (open < n) {
        generateParenthesis(result, "$s(", open + 1, close, n)
    }
    // If we need more close parentheses to balance
    if (close < open) {
        generateParenthesis(result, "$s)", open, close + 1, n)
    }
}

fun main() {
    println(generateParenthesis(3))
    println(generateParenthesis(1))
    println(generateParenthesis(8))
}