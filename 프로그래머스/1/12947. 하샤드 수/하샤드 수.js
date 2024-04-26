function solution(x) {
    const num = x;
    let sum = 0;
    while (x > 0) {
        sum += x % 10;
        x = Math.trunc(x / 10);
    }
    return num % sum == 0;
}