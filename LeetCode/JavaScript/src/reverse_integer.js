/**
 * @author Anirudh Sharma 
 */
var reverse = function (x) {
    let isNegative = false;
    if (x < 0) {
        isNegative = true;
        x = -x;
    }
    let reverse = 0;
    while (x > 0) {
        reverse = reverse * 10 + x % 10;
        x = parseInt(x / 10);
    }
    if (reverse >= Math.pow(2, 31) - 1 || reverse <= Math.pow(-2, 31)) {
        return 0;
    }
    return isNegative ? -reverse : reverse;
};

console.log(reverse(342));
console.log(reverse(-430));
console.log(reverse(242353400));