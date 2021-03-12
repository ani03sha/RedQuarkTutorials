package org.redquark.tutorials.leetcode;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    private static int[] searchRange(int[] nums, int target) {
        return new int[]{findFirstOccurrence(nums, target), findLastOccurrence(nums, target)};
    }

    private static int findFirstOccurrence(int[] nums, int target) {
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Index of first occurrence
        int firstOccurrence = -1;
        // Loop until the two pointers meet
        while (left <= right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // Check if we have found the value
            if (nums[middle] == target) {
                firstOccurrence = middle;
                right = middle - 1;
            }
            // If the target is less than the element
            // at the middle index
            else if (target < nums[middle]) {
                right = middle - 1;
            }
            // If the target is greater than the element
            // at the middle index
            else {
                left = middle + 1;
            }
        }
        return firstOccurrence;
    }

    private static int findLastOccurrence(int[] nums, int target) {
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Index of first occurrence
        int lastOccurrence = -1;
        // Loop until the two pointers meet
        while (left <= right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // Check if we have found the value
            if (nums[middle] == target) {
                lastOccurrence = middle;
                left = middle + 1;
            }
            // If the target is less than the element
            // at the middle index
            else if (target < nums[middle]) {
                right = middle - 1;
            }
            // If the target is greater than the element
            // at the middle index
            else {
                left = middle + 1;
            }
        }
        return lastOccurrence;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));

        nums = new int[]{};
        target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));

        nums = new int[]{5, 7, 7, 8, 8, 8, 8, 10};
        target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
