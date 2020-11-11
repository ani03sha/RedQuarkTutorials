package org.redquark.tutorials.leetcode

import java.util.*
import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    // Sort the array
    Arrays.sort(nums)
    // Length of the array
    val n = nums.size
    // Result
    var closest = nums[0] + nums[1] + nums[n - 1]
    // Loop for each element of the array
    for (i in 0 until n - 2) {
        // Left and right pointers
        var j = i + 1
        var k = n - 1
        // Loop for all other pairs
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum <= target) {
                j++
            } else {
                k--
            }
            if (abs(closest - target) > abs(sum - target)) {
                closest = sum
            }
        }
    }
    return closest
}

fun main() {
    val nums = intArrayOf(-1, 2, 1, -4)
    val target = 1
    println(threeSumClosest(nums, target))
}