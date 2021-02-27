package org.redquark.tutorials.leetcode

/**
 * @author Anirudh Sharma
 */
fun search(nums: IntArray, target: Int): Int {
    // Special case
    if (nums.isEmpty()) {
        return -1
    }
    // Left and right pointers in the array
    var left = 0
    var right = nums.size - 1
    // First step is to find the pivot where the
    // array is rotated
    while (left < right) {
        // Middle pointer
        val middle = left + (right - left) / 2
        // If the element at the mid is greater than
        // the element at the right then we can say that
        // the array is rotated after middle index
        if (nums[middle] > nums[right]) {
            left = middle + 1
        } else {
            right = middle
        }
    }
    // After the above loop is completed, then the
    // left index will point to the pivot
    val pivot = left
    left = 0
    right = nums.size - 1
    // Now we will find in which half of the array,
    // our target is present
    if (target >= nums[pivot] && target <= nums[right]) {
        left = pivot
    } else {
        right = pivot
    }
    // Now perform normal binary search
    while (left <= right) {
        val middle = left + (right - left) / 2
        if (nums[middle] == target) {
            return middle
        } else if (target < nums[middle]) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }
    return -1
}

fun main() {
    var nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    var target = 0
    println(search(nums, target))
    nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    target = 3
    println(search(nums, target))
    nums = intArrayOf(1)
    target = 0
    println(search(nums, target))
}