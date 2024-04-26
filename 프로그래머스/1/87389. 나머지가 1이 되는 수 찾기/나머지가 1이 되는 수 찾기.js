function solution(n) {
    let x = n;
    let min = x;
    while (--x > 1) {
        if (n % x == 1 && x < min) min = x;
    }
    return min;
}