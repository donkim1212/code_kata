function solution(s) {
    let ret = "";
    let count = 0;
    for (let i in s) {
        if (s[i] == " ") {
            count = 0;
            ret += " ";
            continue;
        }
        ret += (count++ & 1) ? s[i].toLowerCase() : s[i].toUpperCase();
    } 
    return ret;
}