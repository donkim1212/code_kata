function solution(s) {
    if (s.length == 1) return s;
    let ind = s.length / 2;
    return (s.length & 1) ? s.substring(ind, ind + 1) : s.substring(ind - 1, ind + 1);
}