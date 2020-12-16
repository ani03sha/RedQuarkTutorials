var divide = function (dividend, divisor) {
    const MAX = 2147483647;
    const MIN = -2147483648;
    // Check for overflow
    if (divisor === 0 || (dividend === MIN && divisor === -1)) {
        return MAX;
    }
    if (divisor === dividend) {
        return 1;
    }
    // Sign of result
    const sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
    // Quotient
    let quotient = 0;
    // Take the absolute value
    let absoluteDividend = Math.abs(dividend);
    let absoluteDivisor = Math.abs(divisor);
    // Loop until the  dividend is greater than divisor
    while (absoluteDividend >= absoluteDivisor) {
        // This represents the number of bits shifted or
        // how many times we can double the number
        let shift = 0;
        let shiftedDivisor = absoluteDivisor;
        while (absoluteDividend >= shiftedDivisor) {
            shift++;
            shiftedDivisor = absoluteDivisor << shift;
            // To handle overflow using left shift operator in JS
            if (shiftedDivisor < 0) {
                break;
            }
        }
        // Add the number of times we shifted to the quotient
        quotient += (1 << (shift - 1));
        // Update the dividend for the next iteration
        absoluteDividend -= absoluteDivisor << (shift - 1);
    }
    return sign === -1 ? -quotient : quotient;
};

console.log(divide(10, 3));
console.log(divide(7, -3));
console.log(divide(-2147483648, 1));
console.log(divide(2147483647, 1));
console.log(divide(-2147483648, - 2147483648))
