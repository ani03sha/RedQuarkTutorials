package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a number N and a value K. From the right, set the Kth bit in the binary representation of N.
 * The position of Least Significant Bit(or last bit) is 0, the second last bit is 1 and so on.
 */
public class SetKthBit {

    private static int setKthBit(int N, int K) {
        return N | (1 << (K));
    }

    public static void main(String[] args) {
        System.out.println(setKthBit(10, 2));
        System.out.println(setKthBit(524288, 5));
    }
}
