/** 
 * @author Anirudh Sharma 
 */
function find_maximum_sum(a, k) {
    const n = a.length;
    // Current sum - sum of the current window
    let current_sum = 0;
    // Maximum sum - maximum sum of k consecutive elements in an array
    let maximum_sum = 0;
    // Find the sum of first k elements
    for (let i = 0; i < k; i++) {
        current_sum += a[i];
    }
    // At this point, maximum and current sum will be same
    maximum_sum = current_sum;
    // Loop for the remaining elements by sliding the window
    for (let i = k; i < n; i++) {
        // Discard the left most element
        current_sum -= a[i - k];
        // Included the current element
        current_sum += a[i];
        if (maximum_sum < current_sum) {
            maximum_sum = current_sum;
        }
    }
    return maximum_sum;
}

const a = [1, 4, 2, 10, 2, 3, 1, 0, 20];
const k = 4;
console.log("Maximum sum: " + find_maximum_sum(a, k));