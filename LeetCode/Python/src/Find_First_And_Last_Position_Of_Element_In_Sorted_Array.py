"""
@author Anirudh Sharma
"""
from typing import List


def findFirstOccurrence(nums, target):
    # Left snd right pointers
    left, right = 0, len(nums) - 1
    # Index of first occurrence
    firstOccurrence = -1
    # Loop until the two pointers meet
    while left <= right:
        # Middle index
        middle = left + (right - left) // 2
        # Check if we have found the value
        if target == nums[middle]:
            firstOccurrence = middle
            right = middle - 1
        # If the target is less than the element
        # at the middle index
        elif target < nums[middle]:
            right = middle - 1
        # If the target is greater than the element
        # at the middle index
        else:
            left = middle + 1
    return firstOccurrence


def findLastOccurrence(nums, target):
    # Left snd right pointers
    left, right = 0, len(nums) - 1
    # Index of first occurrence
    lastOccurrence = -1
    # Loop until the two pointers meet
    while left <= right:
        # Middle index
        middle = left + (right - left) // 2
        # Check if we have found the value
        if target == nums[middle]:
            lastOccurrence = middle
            left = middle + 1
        # If the target is less than the element
        # at the middle index
        elif target < nums[middle]:
            right = middle - 1
        # If the target is greater than the element
        # at the middle index
        else:
            left = middle + 1
    return lastOccurrence


def searchRange(nums: List[int], target: int) -> List[int]:
    return [findFirstOccurrence(nums, target), findLastOccurrence(nums, target)]


if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    print(searchRange(nums, target))

    nums = [5, 7, 7, 8, 8, 10]
    target = 6
    print(searchRange(nums, target))

    nums = []
    target = 0
    print(searchRange(nums, target))

    nums = [5, 7, 7, 8, 8, 8, 8, 10]
    target = 8
    print(searchRange(nums, target))
