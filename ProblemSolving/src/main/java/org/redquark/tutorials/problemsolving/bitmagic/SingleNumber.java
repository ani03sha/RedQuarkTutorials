package org.redquark.tutorials.problemsolving.bitmagic;

/**
 * At a party of N people, each person is denoted by an integer.
 * Couples are represented by the same number. Find out the only singe person in the party of couples.
 */
public class SingleNumber {

    private static int findSingle(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 1};
        System.out.println(findSingle(nums));

        nums = new int[]{1, 2, 3, 5, 3, 2, 1, 4, 5, 6, 6};
        System.out.println(findSingle(nums));
    }
}
