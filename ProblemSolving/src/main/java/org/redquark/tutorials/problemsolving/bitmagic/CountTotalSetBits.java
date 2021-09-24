package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given a number n, find the total count of set bits for all numbers from 1 to N(both inclusive).
 */
public class CountTotalSetBits {

    private static int count(int n) {
        // Special case
        if (n <= 0) {
            return 0;
        }
        // Get maximum power of two less than n
        int maxPower = getMaximumPowerOfTwo(n);
        // Now calculate the total number of set bits
        return maxPower * (1 << (maxPower - 1))
                + (n - (1 << maxPower) + 1)
                + count(n - (1 << maxPower));
    }

    private static int getMaximumPowerOfTwo(int n) {
        int power = 0;
        while ((1 << power) <= n) {
            power++;
        }
        return power - 1;
    }

    public static void main(String[] args) {
        System.out.println(count(4));
        System.out.println(count(17));
    }
}
