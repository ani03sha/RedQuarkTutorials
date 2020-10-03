function maximum_sum(a) {
    if (!a || a.length == 0) {
        return 0;
    }
    let localMaximum = a[0];
    let globalMaximum = a[0];
    for(let i = 0; i < a.length; i++) {
        localMaximum = Math.max(a[i], localMaximum + a[i]);
        if(globalMaximum < localMaximum) {
            globalMaximum = localMaximum;
        }
    }
    return globalMaximum;
}

a = [-2, -3, 4, -1, -2, 1, 5, -3];
console.log(maximum_sum(a));

a = [-2, 1, -3, 4, -1, 2, 1, -5, 4];
console.log(maximum_sum(a));

a = [0, 1, 2, -2, 3, 2];
console.log(maximum_sum(a));

a = [-2, 2, 5, -11, 6];
console.log(maximum_sum(a));