var generateParenthesis = function (n) {
    // Resultant list
    const result = [];
    // Recursively generate parentheses
    generate(result, "", 0, 0, n);
    return result;
};

function generate(result, s, open, close, n) {
    // Base condition
    if (open === n && close === n) {
        result.push(s);
        return;
    }
    // If the number of _open parentheses is less than the given n
    if (open < n) {
        generate(result, s + "(", open + 1, close, n);
    }
    // If we need more close parentheses to balance
    if (close < open) {
        generate(result, s + ")", open, close + 1, n);
    }
}

console.log(generateParenthesis(3));
console.log(generateParenthesis(1));
console.log(generateParenthesis(8));