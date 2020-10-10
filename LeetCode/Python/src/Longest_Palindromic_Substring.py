"""
@author - Anirudh Sharma
"""


def get_updated_string(s):
    sb = ''
    for i in range(0, len(s)):
        sb += '#' + s[i]
    sb += '#'
    return sb


def longestPalindrome(s: str) -> str:
    # Update the string to put hash "#" at the beginning, end and in between each character
    updated_string = get_updated_string(s)
    # Length of the array that will store the window of palindromic substring
    length = 2 * len(s) + 1
    # List to store the length of each palindrome centered at each element
    p = [0] * length
    # Current center of the longest palindromic string
    c = 0
    # Right boundary of the longest palindromic string
    r = 0
    # Maximum length of the substring
    maxLength = 0
    # Position index
    position = -1
    for i in range(0, length):
        # Mirror of the current index
        mirror = 2 * c - i
        # Check if the mirror is outside the left boundary of current longest palindrome
        if i < r:
            p[i] = min(r - i, p[mirror])
        # Indices of the characters to be compared
        a = i + (1 + p[i])
        b = i - (1 + p[i])
        # Expand the window
        while a < length and b >= 0 and updated_string[a] == updated_string[b]:
            p[i] += 1
            a += 1
            b -= 1
        # If the expanded palindrome is expanding beyond the right boundary of
        # the current longest palindrome, then update c and r
        if i + p[i] > r:
            c = i
            r = i + p[i]
        if maxLength < p[i]:
            maxLength = p[i]
            position = i
    offset = p[position]
    result = ''
    for i in range(position - offset + 1, position + offset):
        if updated_string[i] != '#':
            result += updated_string[i]
    return result


if __name__ == '__main__':
    print(longestPalindrome('babad'))
    print(longestPalindrome('cbbd'))
    print(longestPalindrome('a'))
    print(longestPalindrome('ac'))
    print(longestPalindrome('abb'))
