package org.redquark.tutorials.leetcode

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        // Special case
        if (haystack == needle) {
            return 0
        }
        // length of the needle
        val needleLength = needle.length
        // Loop through the haystack and slide the window
        for (i in 0 until haystack.length - needleLength + 1) {
            // Check if the substring equals to the needle
            if (haystack.substring(i, i + needleLength) == needle) {
                return i
            }
        }
        return -1
    }
}

fun main() {
    val i = ImplementStrStr()
    var haystack = "hello"
    var needle = "ll"
    println(i.strStr(haystack, needle))
    haystack = "aaaaa"
    needle = "bba"
    println(i.strStr(haystack, needle))
    haystack = ""
    needle = ""
    println(i.strStr(haystack, needle))
    haystack = "abc"
    needle = "c"
    println(i.strStr(haystack, needle))
}