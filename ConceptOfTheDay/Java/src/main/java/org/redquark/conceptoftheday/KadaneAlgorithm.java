package org.redquark.conceptoftheday;

/**
 * @author Anirudh Sharma
 */
public class KadaneAlgorithm {

    private static int maximumSum(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int globalMaximum = a[0];
        int localMaximum = a[0];
        for (int i = 1; i < a.length; i++) {
            localMaximum = Math.max(a[i], a[i] + localMaximum);
            if (globalMaximum < localMaximum) {
                globalMaximum = localMaximum;
            }
        }
        return globalMaximum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum sum: " + maximumSum(a));

        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum: " + maximumSum(a));

        a = new int[]{0, 1, 2, -2, 3, 2};
        System.out.println("Maximum sum: " + maximumSum(a));

        a = new int[]{-2, 2, 5, -11, 6};
        System.out.println("Maximum sum: " + maximumSum(a));
    }
}
