package org.redquark.tutorials.leetcode

fun longestValidParentheses(s: String): Int {
    // Variable to store the longest valid parentheses
    var count = 0
    // Left counter will count the number of '('
    var left = 0
    // Right counter will count the number of ')'
    var right = 0
    // Loop through the string from left to right.
    // This will take care of extra right parentheses
    for (element in s) {
        // Current character
        if (element == '(') {
            left++
        }
        if (element == ')') {
            right++
        }
        // If both left and right are equal,
        // it means we have a valid substring
        if (left == right) {
            count = count.coerceAtLeast(left + right)
        }
        // If right is greater than left,
        // it means we need to set both
        // counters to zero
        if (right > left) {
            right = 0
            left = right
        }
    }
    // Reset left and right
    right = 0
    left = right
    // Follow the same approach but now loop the string
    // from right to left. This will take care of extra
    // left parentheses
    for (i in s.length - 1 downTo 0) {
        // Current character
        val c = s[i]
        if (c == '(') {
            left++
        }
        if (c == ')') {
            right++
        }
        // If both left and right are equal,
        // it means we have a valid substring
        if (left == right) {
            count = count.coerceAtLeast(left + right)
        }
        // If right is greater than left,
        // it means we need to set both
        // counters to zero
        if (left > right) {
            right = 0
            left = right
        }
    }
    return count
}

fun main() {
    var s = "(()"
    println(longestValidParentheses(s))

    s = ")()())"
    println(longestValidParentheses(s))

    s = ""
    println(longestValidParentheses(s))
}