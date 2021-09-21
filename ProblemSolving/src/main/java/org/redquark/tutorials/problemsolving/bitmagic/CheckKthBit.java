package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given a number n and a bit number k, check if kth bit of n is set or not. A bit is called set if it is 1.
 * Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
 */
public class CheckKthBit {

    private static boolean checkKthBit(int n, int k) {
        // Variable for shifting
        int mask = 1;
        // Shift k positions
        for (int i = 0; i < k; i++) {
            mask <<= 1;
        }
        // Negate the shift
        mask = ~mask;
        // OR the shift with n
        return (mask | n) == ~0;
    }

    public static void main(String[] args) {
        System.out.println(checkKthBit(4, 0));
        System.out.println(checkKthBit(4, 2));
        System.out.println(checkKthBit(500, 3));
    }
}
