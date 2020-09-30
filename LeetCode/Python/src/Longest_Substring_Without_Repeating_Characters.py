"""
@author - Anirudh Sharma
"""


def lengthOfLongestSubstring(s: str) -> int:
    # Base condition
    if s == "":
        return 0
    # Starting index of window
    start = 0
    # Ending index of window
    end = 0
    # Maximum length of substring without repeating characters
    maxLength = 0
    # Set to store unique characters
    unique_characters = set()
    # Loop for each character in the string
    while end < len(s):
        if s[end] not in unique_characters:
            unique_characters.add(s[end])
            end += 1
            maxLength = max(maxLength, len(unique_characters))
        else:
            unique_characters.remove(s[start])
            start += 1
    return maxLength


sample_string = "abcabcbb"
print(lengthOfLongestSubstring(sample_string))

sample_string = "bbbbb"
print(lengthOfLongestSubstring(sample_string))

sample_string = "pwwkew"
print(lengthOfLongestSubstring(sample_string))

sample_string = ""
print(lengthOfLongestSubstring(sample_string))

sample_string = "aab"
print(lengthOfLongestSubstring(sample_string))
