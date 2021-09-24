package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Give an integer, reverse its bits. For e.g., if the input is 10011, then the output should be 11001.
 */
public class ReverseBits {

    private static int reverse(int n) {
        // Special case
        if (n == 0) {
            return 0;
        }
        // Sequence of 0s
        int m = 0;
        // Loop from LSB to MSB
        for (int i = 31; i >= 0 & n != 0; i--) {
            // If the current bit in n is 1, set the corresponding bit in m
            if ((n & 1) != 0) {
                m |= (1 << i);
            }
            n >>= 1;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(reverse(4));
        System.out.println(reverse(6));
    }
}
