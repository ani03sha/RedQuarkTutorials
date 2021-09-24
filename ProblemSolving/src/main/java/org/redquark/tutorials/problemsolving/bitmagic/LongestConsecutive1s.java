package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * Given a number n, ind the length of the longest consecutive 1s in its binary representation.
 */
public class LongestConsecutive1s {

    private static int maxConsecutiveOnes(int N) {
        int maxConsecutiveOnesCount = 0;
        while (N != 0) {
            N &= (N << 1);
            maxConsecutiveOnesCount++;
        }
        return maxConsecutiveOnesCount;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(14));
        System.out.println(maxConsecutiveOnes(222));
    }
}
