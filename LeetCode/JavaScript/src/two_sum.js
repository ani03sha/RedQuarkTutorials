// @author Anirudh Sharma

var twoSum = function (nums, target) {
    // Array to store the result
    result = [];
    // Map to store the difference and its index
    index_map = new Map();
    // Loop for each element in the array
    for (let i = 0; i < nums.length; i++) {
        let difference = target - nums[i];
        if (index_map.has(difference)) {
            result[0] = i;
            result[1] = index_map.get(difference);
            break;
        } else {
            index_map.set(nums[i], i);
        }
    }
    return result;
};

let nums = [2, 7, 11, 15];
let target = 9;
console.log(twoSum(nums, target));

nums = [3, 2, 4];
target = 6;
console.log(twoSum(nums, target));