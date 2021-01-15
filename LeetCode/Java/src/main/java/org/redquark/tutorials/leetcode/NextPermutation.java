package org.redquark.tutorials.leetcode;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * <p>
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order
 * (i.e., sorted in ascending order).
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation {

    /**
     * @param nums - array of numbers
     */
    private static int[] nextPermutation(int[] nums) {
        // Length of the array
        int n = nums.length;
        // Index of the first element that is smaller than
        // the element to its right.
        int index = -1;
        // Loop from right to left
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        // Base condition
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }
        int j = n - 1;
        // Again swap from right to left to find first element
        // that is greater than the above find element
        for (int i = n - 1; i >= index + 1; i--) {
            if (nums[i] > nums[index]) {
                j = i;
                break;
            }
        }
        // Swap the elements
        swap(nums, index, j);
        // Reverse the elements from index + 1 to the nums.length
        reverse(nums, index + 1, n - 1);
        return nums;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int index) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 1, 5})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1})));
    }
}

