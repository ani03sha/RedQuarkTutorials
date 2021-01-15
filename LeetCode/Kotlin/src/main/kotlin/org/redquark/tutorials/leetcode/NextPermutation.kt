package org.redquark.tutorials.leetcode

class NextPermutation {

    fun nextPermutation(nums: IntArray): IntArray {
        // Length of the array
        val n = nums.size
        // Index of the first element that is smaller than
        // the element to its right.
        var index = -1
        // Loop from right to left
        for (i in n - 1 downTo 1) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1
                break
            }
        }
        // Base condition
        if (index == -1) {
            reverse(nums, 0, n - 1)
            return nums
        }
        var j = n - 1
        // Again swap from right to left to find first element
        // that is greater than the above find element
        for (i in n - 1 downTo index + 1) {
            if (nums[i] > nums[index]) {
                j = i
                break
            }
        }
        // Swap the elements
        swap(nums, index, j)
        // Reverse the elements from index + 1 to the nums.length
        reverse(nums, index + 1, n - 1)
        return nums
    }

    private fun reverse(nums: IntArray, i: Int, j: Int) {
        var iIndex = i
        var jIndex = j
        while (iIndex < jIndex) {
            swap(nums, iIndex, jIndex)
            iIndex++
            jIndex--
        }
    }

    private fun swap(nums: IntArray, i: Int, index: Int) {
        val temp = nums[index]
        nums[index] = nums[i]
        nums[i] = temp
    }
}

fun main() {
    val n = NextPermutation()
    println(n.nextPermutation(intArrayOf(1, 2, 3)).contentToString())
    println(n.nextPermutation(intArrayOf(3, 2, 1)).contentToString())
    println(n.nextPermutation(intArrayOf(1, 1, 5)).contentToString())
    println(n.nextPermutation(intArrayOf(1)).contentToString())
    println(n.nextPermutation(intArrayOf(4, 5, 3, 2, 1)).contentToString())
}