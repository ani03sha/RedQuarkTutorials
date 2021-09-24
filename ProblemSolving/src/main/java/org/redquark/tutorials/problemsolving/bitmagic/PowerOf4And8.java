package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given an integer, check if it is a power of 4 and 8 or not
 */
public class PowerOf4And8 {

    private static boolean isPowerOf4(int n) {
        return n != 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }

    private static boolean isPowerOf8(int n) {
        return n != 0 && (n & (n - 1)) == 0 && (n & 0xB6DB6DB6) == 0;
    }

    public static void main(String[] args) {
        int n = 16;
        if (isPowerOf4(n)) {
            System.out.println(n + " is a power of 4");
        } else {
            System.out.println(n + " is not a power of 4");
        }
        if (isPowerOf8(n)) {
            System.out.println(n + " is a power of 8");
        } else {
            System.out.println(n + " is not a power of 8");
        }
        n = 64;
        if (isPowerOf4(n)) {
            System.out.println(n + " is a power of 4");
        } else {
            System.out.println(n + " is not a power of 4");
        }
        if (isPowerOf8(n)) {
            System.out.println(n + " is a power of 8");
        } else {
            System.out.println(n + " is not a power of 8");
        }
    }
}
