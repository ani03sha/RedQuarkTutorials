var threeSumClosest = function (nums, target) {
    // Sort the array
    nums.sort((a, b) => a - b);
    // Length of the array
    const n = nums.length;
    // Result
    let closest = nums[0] + nums[1] + nums[n - 1];
    // Loop for each element of the array
    for (let i = 0; i < n - 2; i++) {
        // Left and right pointers
        let j = i + 1;
        let k = n - 1;
        // Loop for all other pairs
        while (j < k) {
            let sum = nums[i] + nums[j] + nums[k];
            if (sum <= target) {
                j++;
            } else {
                k--;
            }
            if (Math.abs(closest - target) > Math.abs(sum - target)) {
                closest = sum;
            }
        }
    }
    return closest;
};


console.log(threeSumClosest([-1, 2, 1, -4], 1));
console.log(threeSumClosest([2, 3, 7, 1, 5, 7, 1, 8, -1, -4, -4, 3], 12))