package org.redquark.tutorials.leetcode

fun maxArea(height: IntArray): Int {
    // Maximum area will be stored in this variable
    var maximumArea = Int.MIN_VALUE
    // Left and right pointers
    var left = 0
    var right = height.size - 1
    // Loop until left and right meet
    while (left < right) {
        // Shorter pole/vertical line
        val shorterLine = height[left].coerceAtMost(height[right])
        // Update maximum area if required
        maximumArea = maximumArea.coerceAtLeast(shorterLine * (right - left))
        // If there is a longer vertical line present
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maximumArea
}

fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1, 1)))
    println(maxArea(intArrayOf(4, 3, 2, 1, 4)))
    println(maxArea(intArrayOf(1, 2, 1)))
    println(maxArea(intArrayOf(3, 9, 3, 4, 7, 2, 12, 6)))
}