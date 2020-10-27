package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class StringToInteger {

    private static int myAtoi(String str) {
        // Base condition
        if (str == null || str.length() < 1) {
            return 0;
        }
        // MAX and MIN values for integers
        final int INT_MAX = 2147483647;
        final int INT_MIN = -2147483648;
        // Trimmed string
        str = str.replaceAll("^\\s+", "");
        // Counter
        int i = 0;
        // Flag to indicate if the number is negative
        boolean isNegative = str.startsWith("-");
        // Flag to indicate if the number is positive
        boolean isPositive = str.startsWith("+");
        if (isNegative) {
            i++;
        } else if (isPositive) {
            i++;
        }
        // This will store the converted number
        double number = 0;
        // Loop for each numeric character in the string iff numeric characters are leading
        // characters in the string
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            number = number * 10 + (str.charAt(i) - '0');
            i++;
        }
        // Give back the sign to the converted number
        number = isNegative ? -number : number;
        if (number < INT_MIN) {
            return INT_MIN;
        }
        if (number > INT_MAX) {
            return INT_MAX;
        }
        return (int) number;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("91283472332"));
        System.out.println(myAtoi("9223372036854775808"));
    }
}
