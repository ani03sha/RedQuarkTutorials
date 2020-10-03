"""
@author Anirudh Sharma
"""


def isCountEqual(text_count, pattern_count):
    for i in range(0, 256):
        if text_count[i] != pattern_count[i]:
            return False
    return True


def find_indices(text, patten):
    # Lengths of input strings
    n = len(text)
    m = len(patten)
    # list that will store the indices
    indices = []
    # Frequency arrays - assuming we have a set of 256 characters
    text_count = [0] * 256
    pattern_count = [0] * 256
    # Loop for the first m characters
    for i in range(0, m):
        text_count[ord(text[i])] += 1
        pattern_count[ord(patten[i])] += 1
    # At this point, we have traversed m characters in both the arrays.
    # Now we will loop through the remaining characters
    for i in range(m, n):
        # Check if the counts of characters in frequency arrays are equal or not
        if isCountEqual(text_count, pattern_count):
            indices.append(i - m)
        # Discard the left most character
        text_count[ord(text[i - m])] -= 1
        # Include the current character
        text_count[ord(text[i])] += 1
    # For the last window
    if isCountEqual(text_count, pattern_count):
        indices.append(n - m)
    return indices


text = "BACDGABCDA"
pattern = "ABCD"
print(str(find_indices(text, pattern))[1:-1])

text = "XYYZXZYZXXYZ"
pattern = "XYZ"
print(str(find_indices(text, pattern))[1:-1])
