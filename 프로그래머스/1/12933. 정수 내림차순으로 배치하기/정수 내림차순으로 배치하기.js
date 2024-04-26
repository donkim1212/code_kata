function solution(n) {
    let counts = new Array(10).fill(0);
    while (n > 0) {
        counts[n % 10]++;
        n = Math.trunc(n / 10);
    }
    let ret = "";
    for (let i = counts.length - 1; i >= 0; i--) {
        for (let j = 0; j < counts[i]; j++) {
            ret += i;
        }
    }
    return parseInt(ret);
}