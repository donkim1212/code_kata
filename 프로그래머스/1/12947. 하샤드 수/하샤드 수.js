function solution(x) {
    const num = x;
    let counts = new Array(10).fill(0);
    while (x > 0) {
        counts[x % 10]++;
        x = Math.trunc(x / 10);
    }
    let sum = 0;
    for (let i = 1; i < counts.length; i++) {
        sum += counts[i] * i;
    }
    return num % sum == 0;
}