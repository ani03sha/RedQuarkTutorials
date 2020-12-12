"""
@author - Anirudh Sharma
"""
from typing import List


class RemoveElement:
    @staticmethod
    def removeElement(nums: List[int], val: int) -> int:
        # Counter for keeping track of elements other than val
        count = 0
        # Loop through all the elements of the array
        for i in range(len(nums)):
            if nums[i] != val:
                # If the element is not val
                nums[count] = nums[i]
                count += 1
        return count


if __name__ == '__main__':
    r = RemoveElement()
    print(r.removeElement([2, 3, 3, 2], 3))
    print(r.removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2))
