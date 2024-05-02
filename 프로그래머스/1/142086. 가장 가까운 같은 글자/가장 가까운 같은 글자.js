function solution(s) {
    // UTF-16
    // a = 97, z = 122
    const check = new Array(123);
    const ret = new Array(s.length);
    for (let i = 0; i < s.length; i++) {
        let cur = s.charCodeAt(i);
        if (check[cur] == undefined) ret[i] = -1;
        else ret[i] = i - check[cur];
        check[cur] = i;
    }
    return ret;
}