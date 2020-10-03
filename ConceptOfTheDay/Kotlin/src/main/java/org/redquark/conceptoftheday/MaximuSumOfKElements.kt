package org.redquark.conceptoftheday

/**
 * @author Anirudh Sharma
 */
fun findMaximumSum(a: IntArray, k: Int): Int {
    val n = a.size
    // Current sum - sum of the current window
    var currentSum = 0
    // Maximum sum - maximum sum of k consecutive elements in an array
    var maximumSum: Int
    // Find the sum of first k elements
    for (i in 0 until k) {
        currentSum += a[i]
    }
    // At this point, maximum and current sum will be same
    maximumSum = currentSum
    // Loop for the remaining elements by sliding the window
    for (i in k until n) {
        // Discard the left most element
        currentSum -= a[i - k]
        // Included the current element
        currentSum += a[i]
        if (maximumSum < currentSum) {
            maximumSum = currentSum
        }
    }
    return maximumSum
}

fun main() {
    val a = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20)
    val k = 4
    println("Maximum sum: " + findMaximumSum(a, k))
}
