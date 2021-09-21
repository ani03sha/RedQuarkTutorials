package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given two numbers M and N, find the position of the rightmost different bit in the binary representation of numbers.
 */
public class RightMostDifferentBit {

    private static int posOfRightMostDiffBit(int m, int n) {
        // Find the XOR of both numbers to get 1 at the position
        // of difference in bits
        int xor = m ^ n;
        // Special case
        if (xor == 0) {
            return 0;
        }
        // Now find the position of the rightmost set bit
        // Position of the first set bit from the right
        int position = 1;
        // Variable for shifting
        int mask = 1;
        // Counting the position of first set bit
        while ((xor & mask) == 0) {
            position++;
            mask <<= 1;
        }
        return position;
    }

    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(11, 9));
        System.out.println(posOfRightMostDiffBit(52, 4));
    }
}
