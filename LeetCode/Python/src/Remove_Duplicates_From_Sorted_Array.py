"""
@author - Anirudh Sharma
"""
from typing import List


class RemoveDuplicatesFromSortedArray:
    def removeDuplicates(self, nums: List[int]) -> int:
        # Length of the update array
        count = 0
        # Loop for all the elements in the array
        for i in range(len(nums)):
            # If the current element is equal to the next element, we skip
            if i < len(nums) - 2 and nums[i] == nums[i + 1]:
                continue
            # We will update the array in place
            nums[count] = nums[i]
            count += 1
        return count


if __name__ == '__main__':
    r = RemoveDuplicatesFromSortedArray()
    print(r.removeDuplicates([1, 1, 2]))
    print(r.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]))
