package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class SearchInRotatedSortedArray {

    private static int search(int[] nums, int target) {
        // Special case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Left and right pointers in the array
        int left = 0;
        int right = nums.length - 1;
        // First step is to find the pivot where the
        // array is rotated
        while (left < right) {
            // Middle pointer
            int middle = left + (right - left) / 2;
            // If the element at the mid is greater than
            // the element at the right then we can say that
            // the array is rotated after middle index
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            }
            // Else, the pivot is in the left part
            else {
                right = middle;
            }
        }
        // After the above loop is completed, then the
        // left index will point to the pivot
        int pivot = left;
        left = 0;
        right = nums.length - 1;
        // Now we will find in which half of the array,
        // our target is present
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }
        // Now perform normal binary search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        System.out.println(search(nums, target));

        nums = new int[]{1};
        target = 0;
        System.out.println(search(nums, target));
    }
}
