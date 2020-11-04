package org.redquark.tutorials.leetcode

fun isMatch(s: String, p: String): Boolean {
    val rows = s.length
    val columns = p.length
    /// Base conditions
    if (rows == 0 && columns == 0) {
        return true
    }
    if (columns == 0) {
        return false
    }
    // DP array
    val dp = Array(rows + 1) { BooleanArray(columns + 1) }
    // Empty string and empty pattern are a match
    dp[0][0] = true
    // Deals with patterns with *
    for (i in 2 until columns + 1) {
        if (p[i - 1] == '*') {
            dp[0][i] = dp[0][i - 2]
        }
    }
    // For remaining characters
    for (i in 1 until rows + 1) {
        for (j in 1 until columns + 1) {
            if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                dp[i][j] = dp[i - 1][j - 1]
            } else if (j > 1 && p[j - 1] == '*') {
                dp[i][j] = dp[i][j - 2]
                if (p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
                    dp[i][j] = dp[i][j] or dp[i - 1][j]
                }
            }
        }
    }
    return dp[rows][columns]
}

fun main() {
    println(isMatch("aa", "a"))
    println(isMatch("aa", "a*"))
    println(isMatch("ab", "."))
    println(isMatch("aab", "c*a*b"))
    println(isMatch("mississippi", "mis*is*p*."))
    println(isMatch("", ".*"))
}