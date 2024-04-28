function solution(n) {
    let ret = "수박수박수박수박수박"; // 10
    for (let i = 10; i < n ; i *= 2) {
        ret += ret;
    }
    return ret.substring(0, n);
}