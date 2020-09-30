package org.redquark.tutorials.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param s - given input string
     * @return - length of longest substring without repeating characters
     */
    private static int lengthOfLongestSubstring(String s) {
        // Base condition
        if (s == null || s.equals("")) {
            return 0;
        }
        // Starting window index
        int start = 0;
        // Ending window index
        int end = 0;
        // Maximum length of substring
        int maxLength = 0;
        // This set will store the unique characters
        Set<Character> uniqueCharacters = new HashSet<>();
        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());
            } else {
                uniqueCharacters.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

        s = "";
        System.out.println(lengthOfLongestSubstring(s));

        s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
