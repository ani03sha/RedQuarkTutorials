package org.redquark.tutorials.leetcode

fun letterCombinations(digits: String): List<String> {
    // Resultant list
    val combinations: MutableList<String> = mutableListOf()
    // Base condition
    if (digits.isEmpty()) {
        return combinations
    }
    // Mappings of letters and numbers
    val lettersAndNumbersMappings = arrayOf(
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
    )
    findCombinations(combinations, digits, StringBuilder(), 0, lettersAndNumbersMappings)
    return combinations
}

fun findCombinations(combinations: MutableList<String>, digits: String, previous: StringBuilder, index: Int, lettersAndNumbersMappings: Array<String>) {
    // Base condition for recursion to stop

    // Base condition for recursion to stop
    if (index == digits.length) {
        combinations.add(previous.toString())
        return
    }
    // Get the letters corresponding to the current index of digits string
    // Get the letters corresponding to the current index of digits string
    val letters = lettersAndNumbersMappings[digits[index] - '0']
    // Loop through all the characters in the current combination of letters
    // Loop through all the characters in the current combination of letters
    for (c in letters.toCharArray()) {
        findCombinations(combinations, digits, previous.append(c), index + 1, lettersAndNumbersMappings)
        previous.deleteCharAt(previous.length - 1)
    }
}

fun main() {
    println(letterCombinations("23"))
    println(letterCombinations(""))
    println(letterCombinations("2"))
}
