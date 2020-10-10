package org.redquark.tutorials.leetcode

fun longestPalindrome(s: String): String {
    // Update the string to put hash "#" at the beginning, end and in between each character
    val updatedString = getUpdatedString(s)
    // Length of the array that will store the window of palindromic substring
    val length = 2 * s.length + 1
    // Array to store the length of each palindrome centered at each element
    val p = IntArray(length)
    // Current center of the longest palindromic string
    var c = 0
    // Right boundary of the longest palindromic string
    var r = 0
    // Maximum length of the substring
    var maxLength = 0
    // Position index
    var position = -1
    for (i in 0 until length) {
        // Mirror of the current index
        val mirror = 2 * c - i
        // Check if the mirror is outside the left boundary of current longest palindrome
        if (i < r) {
            p[i] = (r - i).coerceAtMost(p[mirror])
        }
        // Indices of the characters to be compared
        var a = i + (1 + p[i])
        var b = i - (1 + p[i])
        // Expand the window
        while (a < length && b >= 0 && updatedString[a] == updatedString[b]) {
            p[i]++
            a++
            b--
        }
        // If the expanded palindrome is expanding beyond the right boundary of
        // the current longest palindrome, then update c and r
        if (i + p[i] > r) {
            c = i
            r = i + p[i]
        }
        if (maxLength < p[i]) {
            maxLength = p[i]
            position = i
        }
    }
    val offset = p[position]
    val result = StringBuilder()
    for (i in position - offset + 1 until position + offset) {
        if (updatedString[i] != '#') {
            result.append(updatedString[i])
        }
    }
    return result.toString()
}

fun getUpdatedString(s: String): String {
    val sb = StringBuilder()
    for (element in s) {
        sb.append("#").append(element)
    }
    sb.append("#")
    return sb.toString()
}

fun main() {
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("a"))
    println(longestPalindrome("ac"))
    println(longestPalindrome("abb"))
}