/**
 * @author Anirudh Sharma
 */

function getMaximumValue(W, n, weights, values) {
    // Lookup table
    let lookup = Array.from(Array(n + 1), () => new Array(W + 1))
    // Check for each case
    for (let i = 0; i <= n; i++) {
        for (let j = 0; j <= W; j++) {
            // Base condition - no item, no capacity
            if (i == 0 || j == 0) {
                lookup[i][j] = 0;
            }
            // If we consider the i-th element
            else if (weights[i - 1] <= j) {
                lookup[i][j] = Math.max(values[i - 1] + lookup[i - 1][j - weights[i - 1]], lookup[i - 1][j]);
            }
            // For all other cases, get the values from previous row
            else {
                lookup[i][j] = lookup[i - 1][j];
            }
        }
    }
    return lookup[n][W];
}

function create2DArray(rows, columns) {
    let lookup = [];
}

const weights = [10, 20, 30];
const values = [60, 100, 120];
const W = 50;
const n = weights.length;

console.log("Maximum value: " + getMaximumValue(W, n, weights, values));