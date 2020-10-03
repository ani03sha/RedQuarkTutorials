"""
@author Anirudh Sharma
"""


def find_maximum_sum(a, k):
    n = len(a)
    # Current sum - sum of the current window
    current_sum = 0
    # Maximum sum - maximum sum of k consecutive elements in an array
    maximum_sum = 0
    # Find the sum of first k elements
    for i in range(0, k):
        current_sum += a[i]
    # At this point, maximum and current sum will be same
    maximum_sum = current_sum
    # Loop for the remaining elements by sliding the window
    for i in range(k, n):
        # Discard the left most element
        current_sum -= a[i - k]
        # Include the current element
        current_sum += a[i]
        if maximum_sum < current_sum:
            maximum_sum = current_sum
    return maximum_sum


a = [1, 4, 2, 10, 2, 3, 1, 0, 20]
k = 4
print("Maximum sum:", find_maximum_sum(a, k))
