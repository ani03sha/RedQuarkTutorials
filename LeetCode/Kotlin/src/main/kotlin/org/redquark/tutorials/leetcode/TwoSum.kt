package org.redquark.tutorials.leetcode

/**
 * @param nums   - input array of numbers
 * @param target - the value of target
 * @return - array of indices of two numbers which will add up to target
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    // Array to store result
    val result = IntArray(2)
    // This map will store the difference and the corresponding index
    val map: MutableMap<Int, Int> = HashMap()
    // Loop through the entire array
    for (i in nums.indices) {
        // If we have seen the current element before
        // It means we have already encountered the other number of the pair
        if (map.containsKey(nums[i])) {
            // Index of the current element
            result[0] = i
            // Index of the other element of the pair
            result[1] = map[nums[i]]!!
            break
        } else {
            // Save the difference of the target and the current element
            // with the index of the current element
            map[target - nums[i]] = i
        }
    }
    return result
}

fun main() {
    var nums = intArrayOf(2, 7, 11, 15)
    var target = 9
    println(twoSum(nums, target).contentToString())

    nums = intArrayOf(3, 2, 4)
    target = 6
    println(twoSum(nums, target).contentToString())
}