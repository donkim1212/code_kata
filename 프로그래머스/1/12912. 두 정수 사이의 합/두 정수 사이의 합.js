function solution(a, b) {
    return (a + b) * ((Math.max(a, b) - Math.min(a, b)) + 1) / 2;
}