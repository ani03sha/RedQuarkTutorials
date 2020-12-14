package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class ImplementStrStr {

    private static int strStr(String haystack, String needle) {
        // Base condition
        if (haystack == null || needle == null) {
            return -1;
        }
        // Special case
        if (haystack.equals(needle)) {
            return 0;
        }
        // length of the needle
        int needleLength = needle.length();
        // Loop through the haystack and slide the window
        for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
            // Check if the subtring equals to the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "bba";
        System.out.println(strStr(haystack, needle));

        haystack = "";
        needle = "";
        System.out.println(strStr(haystack, needle));

        haystack = "abc";
        needle = "c";
        System.out.println(strStr(haystack, needle));
    }
}
