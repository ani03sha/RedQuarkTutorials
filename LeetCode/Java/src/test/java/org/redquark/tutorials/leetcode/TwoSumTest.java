package org.redquark.tutorials.leetcode;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    private final TwoSum testObject = new TwoSum();

    @Test
    public void testTwoSum() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] expected = new int[]{0, 1};
        assertArrayEquals(expected, testObject.twoSum(nums, target));

        nums
    }
}