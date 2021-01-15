""""
@author Anirudh Sharma
Implement next permutation, which rearranges numbers into the lexicographically next greater
permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order
(i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100
"""
from typing import List


def reverse(nums, i, j):
    while i < j:
        nums[i], nums[j] = nums[j], nums[i]
        i += 1
        j -= 1


def nextPermutation(nums: List[int]):
    # Length of the array
    n = len(nums)
    # Index of the first element that is smaller than
    # the element to its right.
    index = -1
    # Loop from right to left
    for i in range(n - 1, 0, -1):
        if nums[i] > nums[i - 1]:
            index = i - 1
            break
    # Base condition
    if index == -1:
        reverse(nums, 0, n - 1)
        return nums
    j = n - 1
    # Again swap from right to left to find first element
    # that is greater than the above find element
    for i in range(n - 1, index, -1):
        if nums[i] > nums[index]:
            j = i
            break
    # Swap the elements
    nums[index], nums[j] = nums[j], nums[index]
    # Reverse the elements from index + 1 to the nums.length
    reverse(nums, index + 1, n - 1)
    return nums


if __name__ == "__main__":
    print(nextPermutation([1, 2, 3]))
    print(nextPermutation([3, 2, 1]))
    print(nextPermutation([1, 1, 5]))
    print(nextPermutation([1]))
