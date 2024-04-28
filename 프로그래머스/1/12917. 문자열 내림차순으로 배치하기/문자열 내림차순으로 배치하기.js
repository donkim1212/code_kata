function solution(s) {
    // UTF-16
    // A = 65, Z = 90
    // a = 97, z = 122
    const counts = new Array(123).fill("");
    for (let i = 0; i < s.length; i++) {
        counts[s.charCodeAt(i)] += s[i];
    }
    let ret = "";
    for (let i = counts.length - 1; i >= 65; i--) {
        if (counts[i] != "") ret += counts[i];
    }
    return ret;
}