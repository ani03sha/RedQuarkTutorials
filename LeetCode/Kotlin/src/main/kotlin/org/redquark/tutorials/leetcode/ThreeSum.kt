package org.redquark.tutorials.leetcode

import java.util.*
import kotlin.collections.ArrayList


fun threeSum(nums: IntArray): List<List<Int>> {
    // Sort the array
    Arrays.sort(nums)
    // Length of the array
    val n = nums.size
    // Resultant list
    val triplets: MutableList<List<Int>> = ArrayList()
    // Loop for each element of the array
    for (i in 0 until n) {
        // Skip the duplicates
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        // Left and right pointers
        var j = i + 1
        var k = n - 1
        // Loop for all the remaining pairs
        while (j < k) {
            when {
                nums[i] + nums[j] + nums[k] == 0 -> {
                    triplets.add(listOf(nums[i], nums[j], nums[k]))
                    j++
                    // Never let j refer to the same value twice (in an output) to avoid duplicates
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++
                    }
                }
                nums[i] + nums[j] + nums[k] < 0 -> {
                    j++
                }
                else -> {
                    k--
                }
            }
        }
    }
    return triplets
}

fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf()))
    println(threeSum(intArrayOf(0)))
}