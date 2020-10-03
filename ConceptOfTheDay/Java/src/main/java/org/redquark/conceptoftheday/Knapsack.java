package org.redquark.conceptoftheday;

/**
 * @author Anirudh Sharma
 */
public class Knapsack {

    public static int getMaximumValue(int W, int n, int[] weights, int[] values) {
        // Create the lookup table
        int[][] lookup = new int[n + 1][W + 1];
        // Solve for each case
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                // Base condition - no item, no capacity
                if (i == 0 || j == 0) {
                    lookup[i][j] = 0;
                }
                // If we include the i-th item
                else if (weights[i - 1] <= j) {
                    lookup[i][j] = Math.max(values[i - 1] + lookup[i - 1][j - weights[i - 1]], lookup[i - 1][j]);
                }
                // If we have out of the capacity
                else {
                    lookup[i][j] = lookup[i - 1][j];
                }
            }
        }
        return lookup[n][W];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{10, 20, 30};
        int[] values = new int[]{60, 100, 120};
        int W = 50;
        int n = weights.length;
        System.out.println("Maximum value: " + getMaximumValue(W, n, weights, values));
    }
}
