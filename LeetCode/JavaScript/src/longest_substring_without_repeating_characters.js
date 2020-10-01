var lengthOfLongestSubstring = function (s) {
    // Base condition
    if (!s) {
        return 0;
    }
    // Starting index of the window
    let start = 0;
    // Ending index of the window
    let end = 0;
    // Maximum length of the substring
    let maxLength = 0;
    // Set to store the unique characters
    const uniqueCharacters = new Set();
    // Loop for each character in the string
    while (end < s.length) {
        if (!uniqueCharacters.has(s[end])) {
            uniqueCharacters.add(s[end]);
            end++;
            maxLength = Math.max(maxLength, uniqueCharacters.size);
        } else {
            uniqueCharacters.delete(s[start]);
            start++;
        }
    }
    return maxLength;
};

let sampleString = "abcabcbb";
console.log(lengthOfLongestSubstring(sampleString));

sampleString = "bbbb";
console.log(lengthOfLongestSubstring(sampleString));

sampleString = "pwwkew";
console.log(lengthOfLongestSubstring(sampleString));

sampleString = "";
console.log(lengthOfLongestSubstring(sampleString));

sampleString = "aab";
console.log(lengthOfLongestSubstring(sampleString));