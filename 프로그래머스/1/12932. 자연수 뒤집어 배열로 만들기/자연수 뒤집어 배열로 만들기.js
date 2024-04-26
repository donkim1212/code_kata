function solution(n) {
    let str = "" + n;
    var answer = new Array(str.length);
    for (let i = 0; i < answer.length; i++) {
        answer[i] = n % 10;
        n = Math.trunc(n / 10);
    }
    return answer;
}