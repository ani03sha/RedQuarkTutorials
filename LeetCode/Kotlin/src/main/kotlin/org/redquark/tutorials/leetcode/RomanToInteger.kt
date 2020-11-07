package org.redquark.tutorials.leetcode

fun romanToInt(s: String): Int {
    // Map to store romans numerals
    val romanMap: MutableMap<Char, Int> = HashMap()
    // Fill the map
    romanMap['I'] = 1
    romanMap['V'] = 5
    romanMap['X'] = 10
    romanMap['L'] = 50
    romanMap['C'] = 100
    romanMap['D'] = 500
    romanMap['M'] = 1000
    // Length of the given string
    val n = s.length
    // Variable to store result
    var num = romanMap[s[n - 1]]!!
    // Loop for each character from right to left
    for (i in n - 2 downTo 0) {
        // Check if the character at right of current character is
        // bigger or smaller
        if (romanMap[s[i]]!! >= romanMap[s[i + 1]]!!) {
            num += romanMap[s[i]]!!
        } else {
            num -= romanMap[s[i]]!!
        }
    }
    return num
}

fun main() {
    println(romanToInt("III"))
    println(romanToInt("IV"))
    println(romanToInt("IX"))
    println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
}