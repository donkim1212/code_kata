function solution(arr) {
    if (arr.length == 1) return [-1];
    let min = Number.MAX_VALUE;
    let ind = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
            ind = i;
        }
    }
    arr.splice(ind, 1);
    return arr;
}