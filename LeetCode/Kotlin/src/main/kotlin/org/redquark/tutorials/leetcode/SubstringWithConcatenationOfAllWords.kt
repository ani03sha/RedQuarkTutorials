package org.redquark.tutorials.leetcode


class SubstringWithConcatenationOfAllWords {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        // Resultant list
        val indices: MutableList<Int> = ArrayList()
        // Base conditions
        if (s.isEmpty() || words.isEmpty()) {
            return indices
        }
        // Store the words and their counts in a hash map
        val wordCount: MutableMap<String, Int> = HashMap()
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
        // Length of each word in the words array
        val wordLength = words[0].length
        // Length of all the words combined in the array
        val wordArrayLength = wordLength * words.size
        // Loop for the entire string
        for (i in 0..s.length - wordArrayLength) {
            // Get the substring of length equal to wordArrayLength
            val current = s.substring(i, i + wordArrayLength)
            // Map to store each word of the substring
            val wordMap: MutableMap<String, Int> = HashMap()
            // Index to loop through the words array
            var index = 0
            // Index to get each word in the current
            var j = 0
            // Loop through each word of the words array
            while (index < words.size) {
                // Divide the current string into strings of length of
                // each word in the array
                val part = current.substring(j, j + wordLength)
                // Put this string into the wordMap
                wordMap[part] = wordMap.getOrDefault(part, 0) + 1
                // Update j and index
                j += wordLength
                index++
            }
            // At this point compare the maps
            if (wordCount == wordMap) {
                indices.add(i)
            }
        }
        return indices
    }
}

fun main() {
    val sObject = SubstringWithConcatenationOfAllWords()
    var s = "barfoothefoobarman"
    var words = arrayOf("foo", "bar")
    println(sObject.findSubstring(s, words))

    s = "wordgoodgoodgoodbestword"
    words = arrayOf("word", "good", "best", "word")
    println(sObject.findSubstring(s, words))

    s = "barfoofoobarthefoobarman"
    words = arrayOf("bar", "foo", "the")
    println(sObject.findSubstring(s, words))

    s = "wordgoodgoodgoodbestword"
    words = arrayOf("word", "good", "best", "good")
    println(sObject.findSubstring(s, words))
}