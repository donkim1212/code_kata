function solution(a, b, n) {
    if (n < a) return 0;
    let ret = Math.trunc(n / a) * b;
    return ret + solution (a, b, ret + (n % a));
}