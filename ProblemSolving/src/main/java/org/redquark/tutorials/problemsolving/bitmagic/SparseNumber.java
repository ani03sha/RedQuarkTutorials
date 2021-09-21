package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given a number N, check whether it is sparse or not. A number is said to be a sparse number if no two or
 * more consecutive bits are set in the binary representation.
 */
public class SparseNumber {

    private static boolean isSparse(int n) {
        return (n & (n << 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isSparse(2));
        System.out.println(isSparse(3));
    }
}
