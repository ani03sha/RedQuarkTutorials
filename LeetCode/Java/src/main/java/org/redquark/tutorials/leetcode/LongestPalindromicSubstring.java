package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class LongestPalindromicSubstring {

    private static String longestPalindrome(String s) {
        // Update the string to put hash "#" at the beginning, end and in between each character
        String updatedString = getUpdatedString(s);
        // Length of the array that will store the window of palindromic substring
        int length = 2 * s.length() + 1;
        // Array to store the length of each palindrome centered at each element
        int[] p = new int[length];
        // Current center of the longest palindromic string
        int c = 0;
        // Right boundary of the longest palindromic string
        int r = 0;
        // Maximum length of the substring
        int maxLength = 0;
        // Position index
        int position = -1;
        for (int i = 0; i < length; i++) {
            // Mirror of the current index
            int mirror = 2 * c - i;
            // Check if the mirror is outside the left boundary of current longest palindrome
            if (i < r) {
                p[i] = Math.min(r - i, p[mirror]);
            }
            // Indices of the characters to be compared
            int a = i + (1 + p[i]);
            int b = i - (1 + p[i]);
            // Expand the window
            while (a < length && b >= 0 && updatedString.charAt(a) == updatedString.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }
            // If the expanded palindrome is expanding beyond the right boundary of
            // the current longest palindrome, then update c and r
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
            if (maxLength < p[i]) {
                maxLength = p[i];
                position = i;
            }
        }
        int offset = p[position];
        StringBuilder result = new StringBuilder();
        for (int i = position - offset + 1; i <= position + offset - 1; i++) {
            if (updatedString.charAt(i) != '#') {
                result.append(updatedString.charAt(i));
            }
        }
        return result.toString();
    }

    private static String getUpdatedString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("abb"));
    }
}
