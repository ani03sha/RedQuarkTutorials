package org.redquark.tutorials.leetcode

/**
 * @author Anirudh Sharma
 */
private fun convert(s: String?, numRows: Int): String {
    // Base conditions
    if (s == null || s.isEmpty() || numRows <= 0) {
        return ""
    }
    if (numRows == 1) {
        return s
    }
    // Resultant string
    val result = StringBuilder()
    // Step size
    val step = 2 * numRows - 2
    // Loop for each row
    for (i in 0 until numRows) {
        // Loop for each character in the row
        var j = i
        while (j < s.length) {
            result.append(s[j])
            if (i != 0 && i != numRows - 1 && j + step - 2 * i < s.length) {
                result.append(s[j + step - 2 * i])
            }
            j += step
        }
    }
    return result.toString()
}

fun main() {
    var s = "PAYPALISHIRING"
    var numRows = 3
    println(convert(s, numRows))
    numRows = 4
    println(convert(s, numRows))

    s = "ANIRUDHSHARMAISGREAT"
    println(convert(s, numRows))
}
