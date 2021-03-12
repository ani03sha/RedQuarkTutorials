package org.redquark.tutorials.leetcode

fun searchRange(nums: IntArray, target: Int): IntArray {
    return intArrayOf(findFirstOccurrence(nums, target), findLastOccurrence(nums, target))
}

fun findFirstOccurrence(nums: IntArray, target: Int): Int {
    // Left and right pointers
    var left = 0
    var right = nums.size - 1
    // Index of first occurrence
    var firstOccurrence = -1
    // Loop until the two pointers meet
    while (left <= right) {
        // Middle index
        val middle = left + (right - left) / 2
        // Check if we have found the value
        when {
            nums[middle] == target -> {
                firstOccurrence = middle
                right = middle - 1
            }
            target < nums[middle] -> {
                right = middle - 1
            }
            else -> {
                left = middle + 1
            }
        }
    }
    return firstOccurrence
}

fun findLastOccurrence(nums: IntArray, target: Int): Int {
    // Left and right pointers
    var left = 0
    var right = nums.size - 1
    // Index of first occurrence
    var lastOccurrence = -1
    // Loop until the two pointers meet
    while (left <= right) {
        // Middle index
        val middle = left + (right - left) / 2
        // Check if we have found the value
        when {
            nums[middle] == target -> {
                lastOccurrence = middle
                left = middle + 1
            }
            target < nums[middle] -> {
                right = middle - 1
            }
            else -> {
                left = middle + 1
            }
        }
    }
    return lastOccurrence
}

fun main() {
    var nums = intArrayOf(5, 7, 7, 8, 8, 10)
    var target = 8
    println(searchRange(nums, target).contentToString())

    nums = intArrayOf(5, 7, 7, 8, 8, 10)
    target = 6
    println(searchRange(nums, target).contentToString())

    nums = intArrayOf()
    target = 0
    println(searchRange(nums, target).contentToString())

    nums = intArrayOf(5, 7, 7, 8, 8, 8, 8, 10)
    target = 8
    println(searchRange(nums, target).contentToString())
}