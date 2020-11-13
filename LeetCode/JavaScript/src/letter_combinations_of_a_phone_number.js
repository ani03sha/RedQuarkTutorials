var letterCombinations = function (digits) {
    // Resultant list
    let combinations = [];
    // Base condition
    if (digits == null || digits.length == 0) {
        return combinations;
    }
    // Mappings of letters and numbers
    const lettersAndNumbersMappings = [
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
    ];
    findCombinations(combinations, digits, "", 0, lettersAndNumbersMappings);
    return combinations;
};

function findCombinations(combinations, digits, previous, index, lettersAndNumbersMappings) {
    // Base condition for recursion to stop
    if (index == digits.length) {
        combinations.push(previous);
        return;
    }
    // Get the letters corresponding to the current index of digits string
    let letters = lettersAndNumbersMappings[digits[index] - '0'];
    // Loop through all the characters in the current combination of letters
    for (let i = 0; i < letters.length; i++) {
        findCombinations(combinations, digits, previous + letters[i], index + 1, lettersAndNumbersMappings);
    }
};


console.log(letterCombinations("23"));
console.log(letterCombinations(""));
console.log(letterCombinations("2"));