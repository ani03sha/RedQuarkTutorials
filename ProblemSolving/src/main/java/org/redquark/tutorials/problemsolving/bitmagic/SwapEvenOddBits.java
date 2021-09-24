package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given an unsigned integer n, swap all odd bits with even bits.
 */
public class SwapEvenOddBits {

    private static int swap(int n) {
        // Masks for even and odd bits
        int evenMask = 0xAAAAAAAA;
        int oddMask = 0x55555555;
        // Perform AND operation between even and odd masks
        int evenBits = n & evenMask;
        int oddBits = n & oddMask;
        // Shift even bits to right and odd bits to left to make
        // even bits odd and odd bit even
        evenBits >>= 1;
        oddBits <<= 1;
        return evenBits | oddBits;
    }

    public static void main(String[] args) {
        System.out.println(swap(23));
        System.out.println(swap(2));
    }
}
