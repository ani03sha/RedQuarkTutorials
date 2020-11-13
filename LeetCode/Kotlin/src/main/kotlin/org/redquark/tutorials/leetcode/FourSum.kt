package org.redquark.tutorials.leetcode

import java.util.*
import kotlin.collections.ArrayList


fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    // Resultant list
    val quadruplets: MutableList<List<Int>> = ArrayList()
    // Base condition
    if (nums.size < 4) {
        return quadruplets
    }
    // Sort the array
    Arrays.sort(nums)
    // Length of the array
    val n = nums.size
    // Loop for each element in the array
    for (i in 0 until n - 3) {
        // Check for skipping duplicates
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        // Reducing problem to 3Sum problem
        for (j in i + 1 until n - 2) {
            // Check for skipping duplicates
            if (j != i + 1 && nums[j] == nums[j - 1]) {
                continue
            }
            // Left and right pointers
            var k = j + 1
            var l = n - 1
            // Reducing to two sum problem
            while (k < l) {
                val currentSum = nums[i] + nums[j] + nums[k] + nums[l]
                when {
                    currentSum < target -> {
                        k++
                    }
                    currentSum > target -> {
                        l--
                    }
                    else -> {
                        quadruplets.add(listOf(nums[i], nums[j], nums[k], nums[l]))
                        k++
                        l--
                        // Check for skipping duplicates
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--
                        }
                    }
                }
            }
        }
    }
    return quadruplets
}

fun main() {
    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    println(fourSum(intArrayOf(), 0))
    println(fourSum(intArrayOf(1, 2, 3, 4), 10))
    println(fourSum(intArrayOf(0, 0, 0, 0), 0))
}