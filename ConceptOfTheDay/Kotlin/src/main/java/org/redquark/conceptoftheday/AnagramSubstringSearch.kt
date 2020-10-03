package org.redquark.conceptoftheday

/**
 * @author Anirudh Sharma
 *
 * We are given two strings "text" and "pattern" of size n and m respectively where m < n.
 * Find all the indices in text where anagrams of pattern are found.
 */
private fun findIndices(text: String, pattern: String): List<Int> {
    // Lengths of strings
    val n = text.length
    val m = pattern.length
    // List that will store the indices
    val indices: MutableList<Int> = ArrayList()
    // Frequency arrays - assuming we have a set of 256 characters
    val textCount = IntArray(256)
    val patternCount = IntArray(256)
    // Loop until m
    for (i in 0 until m) {
        textCount[text[i].toInt()]++
        patternCount[pattern[i].toInt()]++
    }
    // At this point, we have traversed m characters in both the arrays.
    // Now we will loop through the remaining characters
    for (i in m until n) {
        // Check if the counts of characters in frequency arrays are equal or not
        if (isCountEqual(textCount, patternCount)) {
            indices.add(i - m)
        }
        // Discard left most character
        textCount[text[i - m].toInt()]--
        // Include current character
        textCount[text[i].toInt()]++
    }
    // Check for the last window
    if (isCountEqual(textCount, patternCount)) {
        indices.add(n - m)
    }
    return indices
}

private fun isCountEqual(textCount: IntArray, patternCount: IntArray): Boolean {
    for (i in 0..255) {
        if (textCount[i] != patternCount[i]) {
            return false
        }
    }
    return true
}

fun main() {
    var text = "BACDGABCDA"
    var pattern = "ABCD"
    println("Anagrams are found at: " + findIndices(text, pattern))

    text = "XYYZXZYZXXYZ"
    pattern = "XYZ"
    println("Anagrams are found at: " + findIndices(text, pattern))
}
