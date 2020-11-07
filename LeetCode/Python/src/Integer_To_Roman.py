"""
@author - Anirudh Sharma
"""


def intToRoman(num: int) -> str:
    M = ["", "M", "MM", "MMM"]
    C = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
    X = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
    I = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
    return M[num // 1000] + C[(num % 1000) // 100] + X[(num % 100) // 10] + I[num % 10]


if __name__ == '__main__':
    print(intToRoman(3))
    print(intToRoman(4))
    print(intToRoman(9))
    print(intToRoman(58))
    print(intToRoman(1994))
