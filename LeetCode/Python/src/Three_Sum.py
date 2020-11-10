"""
@author - Anirudh Sharma
"""
from typing import List


def threeSum(nums: List[int]) -> List[List[int]]:
    # Sort the given array
    nums.sort()
    # Length of the array
    n = len(nums)
    # Resultant list
    triplets = list()
    # Loop for each character in the array
    for i in range(0, n):
        # Avoid duplicates due to i
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        # Left and right pointers
        j = i + 1
        k = n - 1
        # Loop for remaining pairs
        while j < k:
            if nums[i] + nums[j] + nums[k] == 0:
                triplets.append([nums[i], nums[j], nums[k]])
                j += 1
                # Avoid duplicates for j
                while j < k and nums[j] == nums[j - 1]:
                    j += 1
            elif nums[i] + nums[j] + nums[k] < 0:
                j += 1
            else:
                k -= 1
    return triplets


if __name__ == '__main__':
    print(threeSum([-1, 0, 1, 2, -1, -4]))
    print(threeSum([]))
    print(threeSum([-1, -2, 3, -4, -5, 9, -10, -11, 21, -22, -23, 45, -46, -47, 93, -94, -95, 189]))
