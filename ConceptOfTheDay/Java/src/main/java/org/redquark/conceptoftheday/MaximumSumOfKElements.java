package org.redquark.conceptoftheday;

/**
 * @author Anirudh Sharma
 * <p>
 * Find maximum sum of k consecutive elements in the array
 */
public class MaximumSumOfKElements {

    private static int findMaximumSum(int[] a, int k) {
        int n = a.length;
        // Current sum - sum of the current window
        int currentSum = 0;
        // Maximum sum - maximum sum of k consecutive elements in an array
        int maximumSum = 0;
        // Find the sum of first k elements
        for (int i = 0; i < k; i++) {
            currentSum += a[i];
        }
        // At this point, maximum and current sum will be same
        maximumSum = currentSum;
        // Loop for the remaining elements by sliding the window
        for (int i = k; i < n; i++) {
            // Discard the left most element
            currentSum -= a[i - k];
            // Included the current element
            currentSum += a[i];
            if (maximumSum < currentSum) {
                maximumSum = currentSum;
            }
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Maximum sum: " + findMaximumSum(a, k));
    }
}
