"""
@author - Anirudh Sharma
"""
import sys
from typing import List


def findMedianSortedArrays(nums1: List[int], nums2: List[int]) -> float:
    # Check if nums1 is smaller than nums2
    # If not, then we will swap it with nums2
    if len(nums1) > len(nums2):
        nums1, nums2 = nums2, nums1
    # Lengths of two arrays
    m = len(nums1)
    n = len(nums2)
    # Pointers for binary search
    start = 0
    end = m
    # Binary search starts from here
    while start <= end:
        # Partition indices for both the arrays
        partition_nums1 = (start + end) // 2
        partition_nums2 = (m + n + 1) // 2 - partition_nums1
        # Edge cases
        # If there are no elements left on the left side after partition
        maxLeftNums1 = -sys.maxsize if partition_nums1 == 0 else nums1[partition_nums1 - 1]
        # If there are no elements left on the right side after partition
        minRightNums1 = sys.maxsize if partition_nums1 == m else nums1[partition_nums1]
        # Similarly for nums2
        maxLeftNums2 = -sys.maxsize if partition_nums2 == 0 else nums2[partition_nums2 - 1]
        minRightNums2 = sys.maxsize if partition_nums2 == n else nums2[partition_nums2]
        # Check if we have found the match
        if maxLeftNums1 <= minRightNums2 and maxLeftNums2 <= minRightNums1:
            # Check if the combined array is of even/odd length
            if (m + n) % 2 == 0:
                return (max(maxLeftNums1, maxLeftNums2) + min(minRightNums1, minRightNums2)) / 2
            else:
                return max(maxLeftNums1, maxLeftNums2)
        # If we are too far on the right, we need to go to left side
        elif maxLeftNums1 > minRightNums2:
            end = partition_nums1 - 1
        # If we are too far on the left, we need to go to right side
        else:
            start = partition_nums1 + 1
    # If we reach here, it means the arrays are not sorted
    raise Exception("IllegalArgumentException")


if __name__ == '__main__':
    numbers1 = [1, 3]
    numbers2 = [2]
    print(findMedianSortedArrays(numbers1, numbers2))

    numbers1 = [1, 2]
    numbers2 = [3, 4]
    print(findMedianSortedArrays(numbers1, numbers2))

    numbers1 = [0, 0]
    numbers2 = [0, 0]
    print(findMedianSortedArrays(numbers1, numbers2))

    numbers1 = []
    numbers2 = [1]
    print(findMedianSortedArrays(numbers1, numbers2))

    numbers1 = [2]
    numbers2 = []
    print(findMedianSortedArrays(numbers1, numbers2))
