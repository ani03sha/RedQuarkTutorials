"""
@author - Anirudh Sharma
"""


def isMatch(s: str, p: str) -> bool:
    rows, columns = (len(s), len(p))
    # Base conditions
    if rows == 0 and columns == 0:
        return True
    if columns == 0:
        return False
    # DP array
    dp = [[False for j in range(columns + 1)] for i in range(rows + 1)]
    # Since empty string and empty pattern are a match
    dp[0][0] = True
    # Deals with patterns containing *
    for i in range(2, columns + 1):
        if p[i - 1] == '*':
            dp[0][i] = dp[0][i - 2]
    # For remaining characters
    for i in range(1, rows + 1):
        for j in range(1, columns + 1):
            if s[i - 1] == p[j - 1] or p[j - 1] == '.':
                dp[i][j] = dp[i - 1][j - 1]
            elif j > 1 and p[j - 1] == '*':
                dp[i][j] = dp[i][j - 2]
                if p[j - 2] == '.' or p[j - 2] == s[i - 1]:
                    dp[i][j] = dp[i][j] or dp[i - 1][j]
    return dp[rows][columns]


if __name__ == '__main__':
    print(isMatch("aa", "a"))
    print(isMatch("aa", "a*"))
    print(isMatch("ab", "."))
    print(isMatch("aab", "c*a*b"))
    print(isMatch("mississippi", "mis*is*p*."))
    print(isMatch("", ".*"))
