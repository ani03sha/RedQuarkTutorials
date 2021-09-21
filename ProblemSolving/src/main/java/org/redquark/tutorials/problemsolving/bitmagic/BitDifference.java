package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * You are given two numbers A and B, count the number of bits needed to be flipped to convert A to B.
 */
public class BitDifference {

    private static int countBitsFlip(int a, int b) {
        // Find XOR of two numbers to find out different bits
        int xor = a ^ b;
        // Count of 1s in the XOR output
        int count = 0;
        // Loop until xor becomes 0
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBitsFlip(10, 20));
        System.out.println(countBitsFlip(20, 25));
    }
}
