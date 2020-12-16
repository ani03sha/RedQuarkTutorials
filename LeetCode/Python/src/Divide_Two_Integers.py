"""
@author - Anirudh Sharma
"""


class DivideTwoIntegers:
    @staticmethod
    def divide(dividend: int, divisor: int) -> int:
        # MAX and MIN values for integer
        MAX = 2147483647
        MIN = -2147483648
        # Check for overflow
        if divisor == 0 or (dividend == MIN and divisor == -1):
            return MAX
        # Sign of result`
        sign = -1 if (dividend > 0 and divisor < 0) or (dividend < 0 and divisor > 0) else 1
        # Quotient
        quotient = 0
        # Take the absolute value
        absoluteDividend = abs(dividend)
        absoluteDivisor = abs(divisor)
        # Loop until the  dividend is greater than divisor
        while absoluteDividend >= absoluteDivisor:
            # This represents the number of bits shifted or
            # how many times we can double the number
            shift = 0
            while absoluteDividend >= (absoluteDivisor << shift):
                shift += 1
            # Add the number of times we shifted to the quotient
            quotient += (1 << (shift - 1))
            # Update the dividend for the next iteration
            absoluteDividend -= absoluteDivisor << (shift - 1)
        return -quotient if sign == -1 else quotient


if __name__ == '__main__':
    d = DivideTwoIntegers()
    print(d.divide(10, 3))
    print(d.divide(7, -2))
    print(d.divide(2147483647, 1))
    print(d.divide(-2147483648, 1))
