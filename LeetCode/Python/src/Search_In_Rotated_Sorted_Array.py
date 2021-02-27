"""
@author Anirudh Sharma
"""
from typing import List


def search(nums: List[int], target: int) -> int:
    # Special case
    if nums is None or len(nums) == 0:
        return -1
    # Left and right pointers for the array
    left, right = 0, len(nums) - 1
    # First step is to find the pivot where the array
    # is rotated
    while left < right:
        # Middle index
        middle = left + (right - left) // 2
        # If the element at the mid is greater than
        # the element at the right then we can say that
        # the array is rotated after middle index
        if nums[middle] > nums[right]:
            left = middle + 1
        # Else, the pivot is in the left part
        else:
            right = middle
    # After the above loop is completed, then the
    # left index will point to the pivot
    pivot = left
    left, right = 0, len(nums) - 1
    # Now we will find in which half of the array,
    # our targetValue is present
    if nums[pivot] <= target <= nums[right]:
        left = pivot
    else:
        right = pivot
    # Now perform normal binary search
    while left <= right:
        middle = left + (right - left) // 2
        if nums[middle] == target:
            return middle
        elif nums[middle] < target:
            left = middle + 1
        else:
            right = middle - 1
    return -1


if __name__ == '__main__':
    numbers = [4, 5, 6, 7, 0, 1, 2]
    targetValue = 0
    print(search(numbers, targetValue))

    numbers = [4, 5, 6, 7, 0, 1, 2]
    targetValue = 3
    print(search(numbers, targetValue))

    numbers = [1]
    targetValue = 0
    print(search(numbers, targetValue))
