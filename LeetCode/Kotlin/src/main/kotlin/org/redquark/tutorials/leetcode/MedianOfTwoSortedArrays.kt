package org.redquark.tutorials.leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    // Check if num1 is smaller than num2
    // If not, then we will swap num1 with num2
    if (nums1.size > nums2.size) {
        return findMedianSortedArrays(nums2, nums1)
    }
    // Lengths of two arrays
    val m = nums1.size
    val n = nums2.size
    // Pointers for binary search
    var start = 0
    var end = m
    // Binary search starts from here
    while (start <= end) {
        // Partitions of both the array
        val partitionNums1 = (start + end) / 2
        val partitionNums2 = (m + n + 1) / 2 - partitionNums1
        // Edge cases
        // If there are no elements left on the left side after partition
        val maxLeftNums1 = if (partitionNums1 == 0) Int.MIN_VALUE else nums1[partitionNums1 - 1]
        // If there are no elements left on the right side after partition
        val minRightNums1 = if (partitionNums1 == m) Int.MAX_VALUE else nums1[partitionNums1]
        // Similarly for nums2
        val maxLeftNums2 = if (partitionNums2 == 0) Int.MIN_VALUE else nums2[partitionNums2 - 1]
        val minRightNums2 = if (partitionNums2 == n) Int.MAX_VALUE else nums2[partitionNums2]
        // Check if we have found the match
        if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
            // Check if the combined array is of even/odd length
            return if ((m + n) % 2 == 0) {
                (maxLeftNums1.coerceAtLeast(maxLeftNums2) + minRightNums1.coerceAtMost(minRightNums2)) / 2.0
            } else {
                maxLeftNums1.coerceAtLeast(maxLeftNums2).toDouble()
            }
        } else if (maxLeftNums1 > minRightNums2) {
            end = partitionNums1 - 1
        } else {
            start = partitionNums1 + 1
        }
    }
    throw IllegalArgumentException()
}


fun main() {
    var nums1 = intArrayOf(1, 3)
    var nums2 = intArrayOf(2)
    println(findMedianSortedArrays(nums1, nums2))
    nums1 = intArrayOf(1, 2)
    nums2 = intArrayOf(3, 4)
    println(findMedianSortedArrays(nums1, nums2))
    nums1 = intArrayOf(0, 0)
    nums2 = intArrayOf(0, 0)
    println(findMedianSortedArrays(nums1, nums2))
    nums1 = intArrayOf()
    nums2 = intArrayOf(1)
    println(findMedianSortedArrays(nums1, nums2))
    nums1 = intArrayOf(2)
    nums2 = intArrayOf()
    println(findMedianSortedArrays(nums1, nums2))
}