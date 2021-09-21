package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-negative number N and two values L and R, toggle the bits in the range L to R in the binary
 * representation of N, i.e, to toggle bits from the rightmost Lth bit to the rightmost Rth bit.
 * <p>
 * A toggle operation flips a bit 0 to 1 and a bit 1 to 0. Print N after the bits are toggled.
 */
public class ToggleBitsInRange {

    private static int toggleBits(int N, int L, int R) {
        int mask = ((1 << R) - 1) ^ ((1 << (L - 1)) - 1);
        return N ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(toggleBits(17, 2, 3));
        System.out.println(toggleBits(50, 2, 5));
        System.out.println(toggleBits(10812, 7, 7));
    }
}
