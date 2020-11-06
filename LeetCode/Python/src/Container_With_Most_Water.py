"""
@author - Anirudh Sharma
"""
from sys import maxsize
from typing import List


def maxArea(height: List[int]) -> int:
    # This variable will store the maximum area
    max_area = -maxsize
    # Left and right pointers
    left = 0
    right = len(height) - 1
    # Loop until the two pointers meet
    while left < right:
        # Shorter of the two lines
        shorter_line = min(height[left], height[right])
        max_area = max(max_area, shorter_line * (right - left))
        # If there is a longer vertical line present
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1
    return max_area


if __name__ == '__main__':
    print(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
    print(maxArea([1, 1]))
    print(maxArea([4, 3, 2, 1, 4]))
    print(maxArea([1, 2, 3]))
    print(maxArea([3, 9, 3, 4, 7, 2, 12, 6]))
