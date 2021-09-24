package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Check if a given integer n is even or odd.
 */
public class CheckEvenOrOdd {

    private static String check(int n) {
        return (n & 1) == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        System.out.println(check(4));
        System.out.println(check(863));
        System.out.println(check(-124));
        System.out.println(check(-3));
        System.out.println(check(0));
    }
}
