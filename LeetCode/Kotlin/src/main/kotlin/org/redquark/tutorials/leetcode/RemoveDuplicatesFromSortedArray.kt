package org.redquark.tutorials.leetcode

class RemoveDuplicatesFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        // Length of the updated array
        var count = 0
        // Loop for all the elements in the array
        for (i in nums.indices) {
            // If the current element is equal to the next element, we skip
            if (i < nums.size - 1 && nums[i] == nums[i + 1]) {
                continue
            }
            // We will update the array in place
            nums[count] = nums[i]
            count++
        }
        return count
    }
}

fun main() {
    val r = RemoveDuplicatesFromSortedArray()
    println(r.removeDuplicates(intArrayOf(1, 1, 2)))
    println(r.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}