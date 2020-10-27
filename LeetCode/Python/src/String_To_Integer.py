"""
@author - Anirudh Sharma
"""


def myAtoi(s: str) -> int:
    # Base condition
    if s is None or len(s) < 1:
        return 0
    # Max and Min values for the integers
    INT_MAX = 2147483647
    INT_MIN = -2147483648
    # Trimmed string
    s = s.lstrip()
    # Counter
    i = 0
    # Flag to indicate if the number is negative
    isNegative = len(s) > 1 and s[0] == '-'
    # Flag to indicate if the number is positive
    isPositive = len(s) > 1 and s[0] == '+'
    if isNegative:
        i += 1
    elif isPositive:
        i += 1
    # This will store the converted number
    number = 0
    # Loop for each numeric character in the string iff numeric characters are leading
    # characters in the string
    while i < len(s) and '0' <= s[i] <= '9':
        number = number * 10 + (ord(s[i]) - ord('0'))
        i += 1
    # Give back the sign to the number
    if isNegative:
        number = -number
    # Edge cases - integer overflow and underflow
    if number < INT_MIN:
        return INT_MIN
    if number > INT_MAX:
        return INT_MAX
    return number


if __name__ == '__main__':
    print(myAtoi("42"))
    print(myAtoi("   -42"))
    print(myAtoi("4193 with words"))
    print(myAtoi("words and 987"))
    print(myAtoi("-91283472332"))
    print(myAtoi("91283472332"))
    print(myAtoi("9223372036854775808"))
    print(myAtoi(" "))
