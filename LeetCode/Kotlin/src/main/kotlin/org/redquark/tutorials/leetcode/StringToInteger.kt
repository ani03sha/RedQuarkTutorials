package org.redquark.tutorials.leetcode

fun myAtoi(s: String): Int {
    var str = s
    // Base condition
    if (str.isEmpty()) {
        return 0
    }
    // MAX and MIN values for integers
    val max = 2147483647
    val min = -2147483648
    // Trimmed string
    str = str.replace("^\\s+".toRegex(), "")
    // Counter
    var i = 0
    // Flag to indicate if the number is negative
    val isNegative: Boolean = str.startsWith("-")
    // Flag to indicate if the number is positive
    val isPositive: Boolean = str.startsWith("+")
    if (isNegative) {
        i++
    } else if (isPositive) {
        i++
    }
    // This will store the converted number
    var number = 0.0
    // Loop for each numeric character in the string iff numeric characters are leading
    // characters in the string
    while (i < str.length && str[i] >= '0' && str[i] <= '9') {
        number = number * 10 + (str.get(i) - '0')
        i++
    }
    // Give back the sign to the converted number
    number = if (isNegative) -number else number
    if (number < min) {
        return min
    }
    return if (number > max) {
        max
    } else number.toInt()
}


fun main() {
    println(myAtoi("42"))
    println(myAtoi("   -42"))
    println(myAtoi("4193 with words"))
    println(myAtoi("words and 987"))
    println(myAtoi("-91283472332"))
    println(myAtoi("91283472332"))
    println(myAtoi("9223372036854775808"))
}