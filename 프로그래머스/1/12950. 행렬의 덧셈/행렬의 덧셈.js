function solution(arr1, arr2) {
    const ret = new Array(arr1.length);
    for (let i = 0; i < ret.length; i++) {
        ret[i] = new Array(arr1[0].length);
        for (let j = 0; j < ret[i].length; j++) {
            ret[i][j] = arr1[i][j] + arr2[i][j];
        }
    }
    return ret;
}