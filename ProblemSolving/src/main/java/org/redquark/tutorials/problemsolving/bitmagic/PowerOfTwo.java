package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given a non-negative integer N. The task is to check if N is a power of 2.
 * More formally, check if N can be expressed as 2x for some x.
 */
public class PowerOfTwo {

    private static boolean isPowerOfTwo(long n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(65536));
        System.out.println(isPowerOfTwo(32350));
    }
}
