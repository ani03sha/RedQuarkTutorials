package org.redquark.tutorials.leetcode

fun longestCommonPrefix(strs: Array<String>): String {
    // Longest common prefix string
    val longestCommonPrefix = StringBuilder()
    // Base condition
    if (strs.isEmpty()) {
        return longestCommonPrefix.toString()
    }
    // Find the minimum length string from the array
    var minimumLength = strs[0].length
    for (i in 1 until strs.size) {
        minimumLength = minimumLength.coerceAtMost(strs[i].length)
    }
    // Loop for the minimum length
    for (i in 0 until minimumLength) {
        // Get the current character from first string
        val current = strs[0][i]
        // Check if this character is found in all other strings or not
        for (str in strs) {
            if (str[i] != current) {
                return longestCommonPrefix.toString()
            }
        }
        longestCommonPrefix.append(current)
    }
    return longestCommonPrefix.toString()
}

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}