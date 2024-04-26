function solution(n) {
    let x = Math.sqrt(n);
    return (x - Math.trunc(x) == 0) ? Math.pow(x + 1, 2) : -1;
}