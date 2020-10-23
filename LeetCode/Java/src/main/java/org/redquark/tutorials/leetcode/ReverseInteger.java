package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class ReverseInteger {

    private static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        long reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? -reverse : reverse);
    }

    public static void main(String[] args) {
        System.out.println(reverse(321));
        System.out.println(reverse(-45315));
        System.out.println(reverse(-450));
        System.out.println(reverse(Integer.MAX_VALUE));
    }
}
