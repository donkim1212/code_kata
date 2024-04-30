function solution(s, n) {
    // A 65, Z 90, a 97, z 122
    let ret = "";
    for (let i = 0; i < s.length; i++) {
        if (s[i] == ' ') {
            ret += ' ';
            continue;
        }
        let curCode = s.charCodeAt(i);
        const maxCode = curCode < 91 ? 90 : 122;
        if ((curCode += n) > maxCode) curCode -= 26;
        ret += String.fromCharCode(curCode);
    }
    return ret;
}