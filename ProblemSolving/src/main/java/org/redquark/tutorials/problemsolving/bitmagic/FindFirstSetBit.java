package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given an integer an N. The task is to return the position of first set bit found from the right side in the
 * binary representation of the number.
 * <p>
 * Note: If there is no set bit in the integer N, then return 0 from the function.
 */
public class FindFirstSetBit {

    private static int getFirstSetBit(int n) {
        // Special case
        if (n == 0) {
            return 0;
        }
        // Position of the first set bit from the right
        int position = 1;
        // Variable for shifting
        int mask = 1;
        // Counting the position of first set bit
        while ((n & mask) == 0) {
            position++;
            mask <<= 1;
        }
        return position;
    }

    public static void main(String[] args) {
        System.out.println(getFirstSetBit(18));
        System.out.println(getFirstSetBit(12));
    }
}
