function solution(arr, divisor) {
    let tmp = "";
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % divisor == 0) tmp += arr[i] + " ";
    }
    if (tmp == "") return [-1];
    return tmp.substring(0, tmp.length - 1)
        .split(" ")
        .map((e) => { return parseInt(e); })
        .sort((a, b) => a - b);
}