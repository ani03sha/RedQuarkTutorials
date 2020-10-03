package org.redquark.conceptoftheday

import kotlin.math.max

/**
 * @author Anirudh Sharma
 */

fun getMaximumValue(W: Int, n: Int, weights: IntArray, values: IntArray): Int {
    // Lookup table
    val lookup = Array(n + 1) { i -> Array(W + 1) { j -> 0 } }
    // Loop for each case
    for (i in 0..n) {
        for (j in 0..W) {
            // Base condition - no item, no capacity
            if (i == 0 || j == 0) {
                lookup[i][j] = 0
            }
            // For the i-th element
            else if (weights[i - 1] <= j) {
                lookup[i][j] = max(values[i - 1] + lookup[i - 1][j - weights[i - 1]], lookup[i - 1][j])
            }
            // For all other cases take value from the previous row
            else {
                lookup[i][j] = lookup[i - 1][j]
            }
        }
    }
    return lookup[n][W]
}

fun main() {
    val weights = intArrayOf(10, 20, 30)
    val values = intArrayOf(60, 100, 120)
    val W = 50
    val n = weights.size
    println("Maximum sum: " + getMaximumValue(W, n, weights, values))
}