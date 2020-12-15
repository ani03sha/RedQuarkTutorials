package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class DivideTwoIntegers {

    private static int divide(int dividend, int divisor) {
        // Check for overflow
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // Sign of result
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        // Quotient
        int quotient = 0;
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);
        // loop until sum is less than the dividend
        while (absoluteDividend >= absoluteDivisor) {
            int shift = 0;
            while (absoluteDividend >= (absoluteDivisor << shift)) {
                shift++;
            }
            quotient += (1 << (shift - 1));
            absoluteDividend -= absoluteDivisor << (shift - 1);
        }
        return quotient * sign;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }
}
