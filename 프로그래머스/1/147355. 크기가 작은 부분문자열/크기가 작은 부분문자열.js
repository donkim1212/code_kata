function solution(t, p) {
    let count = 0;
    const pLen = p.length;
    for (let i = 0; i < t.length - pLen + 1; i++) {
        if (t.substring(i, i + pLen) <= p) count++;
    }
    return count;
}