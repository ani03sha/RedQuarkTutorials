package org.redquark.tutorials.leetcode


private fun lengthOfLongestSubstring(s: String): Int {
    // Base condition
    if (s == "") {
        return 0
    }
    // Starting window index
    var start = 0
    // Ending window index
    var end = 0
    // Maximum length of substring
    var maxLength = 0
    // This set will store the unique characters
    val uniqueCharacters: MutableSet<Char> = HashSet()
    while (end < s.length) {
        if (uniqueCharacters.add(s[end])) {
            end++
            maxLength = maxLength.coerceAtLeast(uniqueCharacters.size)
        } else {
            uniqueCharacters.remove(s[start])
            start++
        }
    }
    return maxLength
}

fun main() {
    var s = "abcabcbb"
    println(lengthOfLongestSubstring(s))

    s = "bbbbb"
    println(lengthOfLongestSubstring(s))

    s = "pwwkew"
    println(lengthOfLongestSubstring(s))

    s = ""
    println(lengthOfLongestSubstring(s))

    s = "aab"
    println(lengthOfLongestSubstring(s))
}