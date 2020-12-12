package org.redquark.tutorials.leetcode

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        // Counter for keeping track of elements other than val
        var count = 0
        // Loop through all the elements of the array
        for (i in nums.indices) {
            // If the element is not val
            if (nums[i] != `val`) {
                nums[count++] = nums[i]
            }
        }
        return count
    }
}

fun main() {
    val r = RemoveElement()
    println(r.removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(r.removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}