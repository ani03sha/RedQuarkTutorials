"""
@author - Anirudh Sharma
"""
from typing import List


class SubstringWithConcatenationOfAllWords:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        # Resultant list
        indices = []
        # Base conditions
        if s is None or len(s) == 0 or words is None or len(words) == 0:
            return indices

        # Dictionary to store the count of each word in the words array
        wordCount = dict()
        # Loop to store count of each word in the array
        for i in range(len(words)):
            if words[i] in wordCount:
                wordCount[words[i]] += 1
            else:
                wordCount[words[i]] = 1
        # Length of each word in the words array
        wordLength = len(words[0])
        # Total length of all the words in the array
        wordArrayLength = wordLength * len(words)
        # Loop for each character in the string
        for i in range(0, len(s) - wordArrayLength + 1):
            # Get the current string
            current = s[i:i + wordArrayLength]
            # Map to store the count of each word in the current
            wordMap = dict()
            # Index to loop through the array
            index = 0
            # Index to partition the current string
            j = 0
            # Loop through the words array
            while index < len(words):
                # Partition the string
                part = current[j: j + wordLength]
                # Save this in wordMap
                if part in wordMap:
                    wordMap[part] += 1
                else:
                    wordMap[part] = 1
                # Update the indices
                j += wordLength
                index += 1
            # Compare the two maps
            if wordMap == wordCount:
                indices.append(i)
        return indices


if __name__ == '__main__':
    sObject = SubstringWithConcatenationOfAllWords()
    s = "barfoothefoobarman"
    words = ["foo", "bar"]
    print(sObject.findSubstring(s, words))

    s = "wordgoodgoodgoodbestword"
    words = ["word", "good", "best", "word"]
    print(sObject.findSubstring(s, words))

    s = "barfoofoobarthefoobarman"
    words = ["bar", "foo", "the"]
    print(sObject.findSubstring(s, words))

    s = "wordgoodgoodgoodbestword"
    words = ["word", "good", "best", "good"]
    print(sObject.findSubstring(s, words))
