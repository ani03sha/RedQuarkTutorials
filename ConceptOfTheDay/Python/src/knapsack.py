"""
@author - Anirudh Sharma
"""


def get_maximum_value(W, n, weights, values):
    # Lookup table for memoization
    lookup = [[0 for i in range(W + 1)] for j in range(n + 1)]
    # Loop for items
    for i in range(n + 1):
        for j in range(W + 1):
            # Base condition - no item, no capacity
            if i == 0 or j == 0:
                lookup[i][j] = 0
            # For the i-th item
            elif weights[i - 1] <= j:
                lookup[i][j] = max(values[i - 1] + lookup[i - 1][j - weights[i - 1]], lookup[i - 1][j])
            # Take the values from the previous row
            else:
                lookup[i][j] = lookup[i - 1][j]
    return lookup[n][W]


weights = [10, 20, 30]
values = [60, 100, 120]
W = 50
n = len(weights)

print("Maximum value: ", get_maximum_value(W, n, weights, values))
