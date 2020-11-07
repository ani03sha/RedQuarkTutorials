"""
@author - Anirudh Sharma
"""


def romanToInt(s: str) -> int:
    # Dictionary of roman numerals
    roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    # Length of the given string
    n = len(s)
    # This variable will store result
    num = roman_map[s[n - 1]]
    # Loop for each character from right to left
    for i in range(n - 2, -1, -1):
        # Check if the character at right of current character is bigger or smaller
        if roman_map[s[i]] >= roman_map[s[i + 1]]:
            num += roman_map[s[i]]
        else:
            num -= roman_map[s[i]]
    return num


if __name__ == '__main__':
    print(romanToInt('III'))
    print(romanToInt('IV'))
    print(romanToInt('IX'))
    print(romanToInt('LVIII'))
    print(romanToInt('MCMXCIV'))
