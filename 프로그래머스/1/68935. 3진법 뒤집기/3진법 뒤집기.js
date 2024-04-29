function solution(n) {
    return ternaryToDecimal(getTernery(n));
}

function getTernery (n) {
    if (n < 3) return "" + n;
    return "" + (n % 3) + getTernery(Math.trunc(n / 3));
}

function ternaryToDecimal (n) {
    let ret = 0;
    let exp = 0;
    for (let i = n.length - 1; i >= 0; i--) {
        ret += parseInt(n[i]) * Math.pow(3, exp++);
    }
    return ret;
}