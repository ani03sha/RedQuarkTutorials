"""
@author - Anirudh Sharma
"""
from typing import List


def fourSum(nums: List[int], target: int) -> List[List[int]]:
    # Resultant list
    quadruplets = list()
    # Base condition
    if nums is None or len(nums) < 4:
        return quadruplets
    # Sort the array
    nums.sort()
    # Length of the array
    n = len(nums)
    # Loop for each element of the array
    for i in range(0, n - 3):
        # Check for skipping duplicates
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        # Reducing to three sum problem
        for j in range(i + 1, n - 2):
            # Check for skipping duplicates
            if j != i + 1 and nums[j] == nums[j - 1]:
                continue
            # Left and right pointers
            k = j + 1
            l = n - 1
            # Reducing to two sum problem
            while k < l:
                current_sum = nums[i] + nums[j] + nums[k] + nums[l]
                if current_sum < target:
                    k += 1
                elif current_sum > target:
                    l -= 1
                else:
                    quadruplets.append([nums[i], nums[j], nums[k], nums[l]])
                    k += 1
                    l -= 1
                    while k < l and nums[k] == nums[k - 1]:
                        k += 1
                    while k < l and nums[l] == nums[l + 1]:
                        l -= 1
    return quadruplets


if __name__ == '__main__':
    print(fourSum([1, 0, -1, 0, -2, 2], 0))
    print(fourSum([], 0))
    print(fourSum([1, 2, 3, 4], 10))
    print(fourSum([0, 0, 0, 0], 0))
