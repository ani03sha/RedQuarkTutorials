package org.redquark.tutorials.problemsolving.bitmagic;

public class CountSetBitsInANumber {

    private static int count(int n) {
        // Special case
        if (n == 0) {
            return 0;
        }
        // Count of set bits
        int setBits = 0;
        // Loop until n is greater than 0
        while (n > 0) {
            n &= (n - 1);
            setBits++;
        }
        return setBits;
    }

    public static void main(String[] args) {
        System.out.println(count(4));
        System.out.println(count(9));
        System.out.println(count(63));
    }
}
