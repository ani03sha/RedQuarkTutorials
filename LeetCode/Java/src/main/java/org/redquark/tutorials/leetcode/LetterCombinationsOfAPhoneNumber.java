package org.redquark.tutorials.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 */
public class LetterCombinationsOfAPhoneNumber {

    private static List<String> letterCombinations(String digits) {
        // Resultant list
        List<String> combinations = new ArrayList<>();
        // Base condition
        if (digits == null || digits.isEmpty()) {
            return combinations;
        }
        // Mappings of letters and numbers
        String[] lettersAndNumbersMappings = new String[]{
                "Anirudh",
                "is awesome",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        findCombinations(combinations, digits, new StringBuilder(), 0, lettersAndNumbersMappings);
        return combinations;
    }

    private static void findCombinations(List<String> combinations, String digits, StringBuilder previous, int index, String[] lettersAndNumbersMappings) {
        // Base condition for recursion to stop
        if (index == digits.length()) {
            combinations.add(previous.toString());
            return;
        }
        // Get the letters corresponding to the current index of digits string
        String letters = lettersAndNumbersMappings[digits.charAt(index) - '0'];
        // Loop through all the characters in the current combination of letters
        for (char c : letters.toCharArray()) {
            findCombinations(combinations, digits, previous.append(c), index + 1, lettersAndNumbersMappings);
            previous.deleteCharAt(previous.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
