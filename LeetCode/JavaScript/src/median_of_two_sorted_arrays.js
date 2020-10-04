var findMedianSortedArrays = function (nums1, nums2) {
    // Check if num1 is smaller than num2
    // If not, then we will swap num1 with num2
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }
    // Lengths of two arrays
    const m = nums1.length;
    const n = nums2.length;
    // Pointers for binary search
    let start = 0;
    let end = m;
    // Binary search starts from here
    while (start <= end) {
        // Partitions of both the array
        let partitionNums1 = Math.floor((start + end) / 2);
        let partitionNums2 = Math.floor((m + n + 1) / 2) - partitionNums1;
        // Edge cases
        // If there are no elements left on the left side after partition
        let maxLeftNums1 = partitionNums1 == 0 ? Number.MIN_SAFE_INTEGER : nums1[partitionNums1 - 1];
        // If there are no elements left on the right side after partition
        let minRightNums1 = partitionNums1 == m ? Number.MAX_SAFE_INTEGER : nums1[partitionNums1];
        // Similarly for nums2
        let maxLeftNums2 = partitionNums2 == 0 ? Number.MIN_SAFE_INTEGER : nums2[partitionNums2 - 1];
        let minRightNums2 = partitionNums2 == n ? Number.MAX_SAFE_INTEGER : nums2[partitionNums2];
        // Check if we have found the match
        if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
            // Check if the combined array is of even/odd length
            if ((m + n) % 2 == 0) {
                return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
            } else {
                return Math.max(maxLeftNums1, maxLeftNums2);
            }
        }
        // If we are too far on the right, we need to go to left side
        else if (maxLeftNums1 > minRightNums2) {
            end = partitionNums1 - 1;
        }
        // If we are too far on the left, we need to go to right side
        else {
            start = partitionNums1 + 1;
        }
    }
};

numbers1 = [1, 3];
numbers2 = [2];
console.log(findMedianSortedArrays(numbers1, numbers2));

numbers1 = [1, 2];
numbers2 = [3, 4];
console.log(findMedianSortedArrays(numbers1, numbers2));

numbers1 = [0, 0];
numbers2 = [0, 0];
console.log(findMedianSortedArrays(numbers1, numbers2));

numbers1 = [];
numbers2 = [1];
console.log(findMedianSortedArrays(numbers1, numbers2));

numbers1 = [2];
numbers2 = [];
console.log(findMedianSortedArrays(numbers1, numbers2));