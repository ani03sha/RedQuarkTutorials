"""
@author - Anirudh Sharma
"""


def convert(s: str, numRows: int) -> str:
    # Base condition
    if s is None and numRows <= 0:
        return ""
    if numRows == 1:
        return s
    # Resultant string
    result = ""
    # Step size
    step = 2 * numRows - 2
    # Loop for each row
    for i in range(0, numRows):
        # Loop for each character in the row
        for j in range(i, len(s), step):
            result += s[j]
            if i != 0 and i != numRows - 1 and (j + step - 2 * i) < len(s):
                result += s[j + step - 2 * i]
    return result


if __name__ == '__main__':
    s = "PAYPALISHIRING"
    numRows = 3
    print(convert(s, numRows))

    numRows = 4
    print(convert(s, numRows))

    s = "ANIRUDHSHARMAISGREAT"
    numRows = 5
    print(convert(s, numRows))
