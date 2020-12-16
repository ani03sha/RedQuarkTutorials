package org.redquark.tutorials.leetcode

class DivideTwoIntegers {

    fun divide(dividend: Int, divisor: Int): Int {
        // Check for overflow
        if (divisor == 0 || dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }
        // Sign of result
        val sign = if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) -1 else 1
        // Quotient
        var quotient = 0
        // Take the absolute value
        var absoluteDividend = Math.abs(dividend.toLong())
        val absoluteDivisor = Math.abs(divisor.toLong())
        // Loop until the  dividend is greater than divisor
        while (absoluteDividend >= absoluteDivisor) {
            // This represents the number of bits shifted or
            // how many times we can double the number
            var shift = 0
            while (absoluteDividend >= absoluteDivisor shl shift) {
                shift++
            }
            // Add the number of times we shifted to the quotient
            quotient += 1 shl shift - 1
            // Update the dividend for the next iteration
            absoluteDividend -= absoluteDivisor shl shift - 1
        }
        return if (sign == -1) -quotient else quotient
    }
}

fun main() {
    val d = DivideTwoIntegers()
    println(d.divide(10, 3))
    println(d.divide(7, -3))
    println(d.divide(0, 1))
    println(d.divide(1, 1))
    println(d.divide(Int.MAX_VALUE, 1))
    println(d.divide(Int.MIN_VALUE, 1))
}