"""
@author - Anirudh Sharma
"""
from typing import List


def twoSum(nums: List[int], target: int) -> List[int]:
    # List to store results
    result = []
    # Dictionary to store the difference and its index
    index_map = {}
    # Loop for each element
    for i, n in enumerate(nums):
        # Difference which needs to be checked
        difference = target - n
        if difference in index_map:
            result.append(i)
            result.append(index_map[difference])
            break
        else:
            index_map[n] = i
    return result


numbers = [2, 7, 11, 15]
target_value = 9
print(str(twoSum(numbers, target_value)))

numbers = [3, 2, 4]
target_value = 6
print(str(twoSum(numbers, target_value)))
