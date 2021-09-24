package org.redquark.tutorials.problemsolving.bitmagic;

import java.util.ArrayList;
import java.util.List;

public class GeneratePowerSet {

    private static List<List<Integer>> generate(int[] S) {
        // List to store the output
        List<List<Integer>> powerSet = new ArrayList<>();
        // Special case
        if (S == null || S.length == 0) {
            return powerSet;
        }
        // Length of the array
        int n = S.length;
        // Total number of sets
        int count = 1 << n;
        // Generate each subset one by one
        for (int i = 0; i < count; i++) {
            // List to store current subset
            List<Integer> currentSubset = new ArrayList<>();
            // Check every bit of i
            for (int j = 0; j < n; j++) {
                // If j-th bit of i is set, add it to the list
                if ((i & (1 << j)) != 0) {
                    currentSubset.add(S[j]);
                }
            }
            powerSet.add(currentSubset);
        }
        return powerSet;
    }

    public static void main(String[] args) {
        int[] S = new int[]{1, 2, 3};
        System.out.println(generate(S));

        S = new int[]{11, 12, 13, 14};
        System.out.println(generate(S));
    }
}
