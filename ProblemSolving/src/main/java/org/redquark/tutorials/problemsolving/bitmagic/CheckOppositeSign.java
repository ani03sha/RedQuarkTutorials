package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given two integers a and b, check if they have opposite signs
 */
public class CheckOppositeSign {

    private static boolean check(int a, int b) {
        return (a ^ b) < 0;
    }

    public static void main(String[] args) {
        System.out.println(check(4, 6));
        System.out.println(check(7, -9));
        System.out.println(check(-2, -3));
        System.out.println(check(-1, 8));
    }
}
