var strStr = function (haystack, needle) {
    // Base condition
    if (haystack == null || needle == null) {
        return -1;
    }
    // Special case
    if (haystack === needle) {
        return 0;
    }
    // length of the needle
    const needleLength = needle.length;
    // Loop through the haystack and slide the window
    for (let i = 0; i < haystack.length - needleLength + 1; i++) {
        // Check if the substring equals to the needle
        if (haystack.substring(i, i + needleLength) === needle) {
            return i;
        }
    }
    return -1;
};

let haystackString = "hello";
let needleString = "ll";
console.log(strStr(haystackString, needleString));

haystackString = "aaaaa";
needleString = "bba";
console.log(strStr(haystackString, needleString));

haystackString = "";
needleString = "";
console.log(strStr(haystackString, needleString));

haystackString = "abc";
needleString = "c";
console.log(strStr(haystackString, needleString));