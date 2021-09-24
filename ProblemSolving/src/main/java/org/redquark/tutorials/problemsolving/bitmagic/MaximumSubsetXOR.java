package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given an array nums[] of n positive integers, find an integer denoting the maximum XOR subset
 * value in the given array nums[].
 */
public class MaximumSubsetXOR {

    private static int maximumSubsetXORValue(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Index of the chosen element
        int index = 0;
        // Traverse through the bits of integer from MSB to LSB
        for (int i = 31; i >= 0; i--) {
            // Maximum element
            int maximum = Integer.MIN_VALUE;
            // Index of the maximum element
            int maxElementIndex = index;
            // Find the maximum element with i-th bit set
            for (int j = index; j < n; j++) {
                // Check if the i-th bit of j-th element is set
                // and this element is greater than maximum so far
                if ((nums[j] & (1 << i)) != 0 && nums[j] > maximum) {
                    maximum = nums[j];
                    maxElementIndex = j;
                }
            }
            // If there was no element with i-th bit set, we will
            // continue for the next smaller bit
            if (maximum == Integer.MIN_VALUE) {
                continue;
            }
            // Swap the maximum element with i-th bit set
            int temp = nums[index];
            nums[index] = nums[maxElementIndex];
            nums[maxElementIndex] = temp;
            // Update maximum element index
            maxElementIndex = index;
            // Perform XOR of nums[maxElementIndex] with other elements
            // with i-th set bit
            for (int j = 0; j < n; j++) {
                if (j != maxElementIndex && (nums[j] & (1 << i)) != 0) {
                    nums[j] ^= nums[maxElementIndex];
                }
            }
            index++;
        }
        // XOR of all the final elements
        int xor = nums[0];
        for (int i = 1; i < n; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5};
        System.out.println(maximumSubsetXORValue(nums));

        nums = new int[]{9, 8, 5};
        System.out.println(maximumSubsetXORValue(nums));
    }
}
