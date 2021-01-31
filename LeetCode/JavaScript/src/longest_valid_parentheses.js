/**
 * @author Anirudh Sharma
 * 
 * Given a string containing just the characters '(' and ')', find the length of the
 * longest valid (well-formed) parentheses substring.
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(', or ')'.
 */
var longestValidParentheses = function (s) {
    // Variable to store the longest valid parentheses
    let count = 0;
    // Left counter will count the number of '('
    let left = 0;
    // Right counter will count the number of ')'
    let right = 0;
    // Loop through the string from left to right.
    // This will take care of extra right parentheses
    for (let i = 0; i < s.length; i++) {
        // Current character
        let c = s[i];
        if (c === '(') {
            left++;
        }
        if (c === ')') {
            right++;
        }
        // If both left and right are equal,
        // it means we have a valid substring
        if (left === right) {
            count = Math.max(count, left + right);
        }
        // If right is greater than left,
        // it means we need to set both
        // counters to zero
        if (right > left) {
            left = right = 0;
        }
    }
    // Reset left and right
    left = right = 0;
    // Follow the same approach but now loop the string
    // from right to left. This will take care of extra
    // left parentheses
    for (let i = s.length - 1; i >= 0; i--) {
        // Current character
        let c = s[i];
        if (c === '(') {
            left++;
        }
        if (c === ')') {
            right++;
        }
        // If both left and right are equal,
        // it means we have a valid substring
        if (left === right) {
            count = Math.max(count, left + right);
        }
        // If right is greater than left,
        // it means we need to set both
        // counters to zero
        if (left > right) {
            left = right = 0;
        }
    }
    return count;
};


console.log(longestValidParentheses("(()"));
console.log(longestValidParentheses(")()()"));
console.log(longestValidParentheses(""));