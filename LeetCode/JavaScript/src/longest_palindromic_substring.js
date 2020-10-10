var longestPalindrome = function (s) {
    // Update the string to put hash "#" at the beginning, end and in between each character
    let updatedString = getUpdatedString(s);
    // Length of the array that will store the window of palindromic substring
    const length = 2 * s.length + 1;
    // Array to store the length of each palindrome centered at each element
    let p = new Array(length);
    p.fill(0);
    // Current center of the longest palindromic string
    let c = 0;
    // Right boundary of the longest palindromic string
    let r = 0;
    // Maximum length of the substring
    let maxLength = 0;
    // Position index
    let position = -1;
    for (let i = 0; i < length; i++) {
        // Mirror of the current index
        let mirror = 2 * c - i;
        // Check if the mirror is outside the left boundary of current longest palindrome
        if (i < r) {
            p[i] = Math.min(r - i, p[mirror]);
        }
        // Indices of the characters to be compared
        let a = i + (1 + p[i]);
        let b = i - (1 + p[i]);
        // Expand the window
        while (a < length && b >= 0 && updatedString[a] === updatedString[b]) {
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
    let offset = p[position];
    let result = "";
    for (let i = position - offset + 1; i <= position + offset - 1; i++) {
        if (updatedString[i] !== '#') {
            result += updatedString[i];
        }
    }
    return result;
};

function getUpdatedString(s) {
    let sb = "";
    for (let i = 0; i < s.length; i++) {
        sb += "#" + s[i];
    }
    sb += "#";
    return sb;
}

console.log(longestPalindrome("babad"));
console.log(longestPalindrome("cbbd"));
console.log(longestPalindrome("a"));
console.log(longestPalindrome("ac"));
console.log(longestPalindrome("abb"));