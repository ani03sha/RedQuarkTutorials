package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class LongestCommonPrefix {

    /**
     * @param strs - input array of strings
     * @return longest common prefix
     */
    private static String longestCommonPrefix(String[] strs) {
        // Longest common prefix string
        StringBuilder longestCommonPrefix = new StringBuilder();
        // Base condition
        if (strs == null || strs.length == 0) {
            return longestCommonPrefix.toString();
        }
        // Find the minimum length string from the array
        int minimumLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minimumLength = Math.min(minimumLength, strs[i].length());
        }
        // Loop for the minimum length
        for (int i = 0; i < minimumLength; i++) {
            // Get the current character from first string
            char current = strs[0].charAt(i);
            // Check if this character is found in all other strings or not
            for (String str : strs) {
                if (str.charAt(i) != current) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(current);
        }
        return longestCommonPrefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
