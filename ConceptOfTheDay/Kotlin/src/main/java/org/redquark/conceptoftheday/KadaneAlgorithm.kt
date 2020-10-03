package org.redquark.conceptoftheday

import kotlin.math.max

fun maximumSum(a: IntArray): Int {
    if (a.isEmpty()) {
        return 0
    }
    var globalMaximum = a[0]
    var localMaximum = a[0]
    for (i in 1 until a.size) {
        localMaximum = max(a[i], localMaximum + a[i])
        if (globalMaximum < localMaximum) {
            globalMaximum = localMaximum
        }
    }
    return globalMaximum
}

fun main() {
    var a = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
    println("Maximum sum: " + maximumSum(a))

    a = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println("Maximum sum: " + maximumSum(a))

    a = intArrayOf(0, 1, 2, -2, 3, 2)
    println("Maximum sum: " + maximumSum(a))

    a = intArrayOf(-2, 2, 5, -11, 6)
    println("Maximum sum: " + maximumSum(a))
}