var threeSum = function (nums) {
    // Sort the array
    nums.sort((a, b) => a - b);
    // Length of the array
    const n = nums.length;
    // Resultant list
    const triplets = [];
    // Loop for each element of the array
    for (let i = 0; i < n; i++) {
        // Skip the duplicates
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        // Left and right pointers
        let j = i + 1;
        let k = n - 1;
        // Loop for all the remaining pairs
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] === 0) {
                triplets.push([nums[i], nums[j], nums[k]]);
                j++;
                // Never let j refer to the same value twice (in an output) to avoid duplicates
                while (j < k && nums[j] === nums[j - 1]) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
    return triplets;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4]));
console.log(threeSum([]));