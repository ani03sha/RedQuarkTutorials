"""
@author - Anirudh Sharma
"""
import sys


def reverse(x: int) -> int:
    isNegative = False
    if x < 0:
        isNegative = True
        x = -x
    reversedNumber = 0
    while x:
        reversedNumber = reversedNumber * 10 + x % 10
        x //= 10
    if reversedNumber >= 2 ** 31 - 1 or reversedNumber <= -2 ** 31:
        return 0
    return -reversedNumber if isNegative else reversedNumber


if __name__ == '__main__':
    print(reverse(2342))
    print(reverse(-4345))
    print(reverse(340))
    print(sys.maxsize)
