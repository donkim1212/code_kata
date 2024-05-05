function solution(number) {
    const sorted = getSortedArr(number);
    return getTrioCount(sorted);
}

function getTrioCount (arr) {
    let count = 0;
    for (let i = 0; i < arr.length - 2; i++) {
        for (let j = i + 1; j < arr.length - 1; j++) {
            let cur = arr[i] + arr[j];
            if (cur > 0) break;
            for (let k = arr.length - 1; k >= j + 1; k--) {
                if (cur + arr[k] < 0) break;
                if (cur + arr[k] == 0) count++;
            }
        }
    }
    return count;
}

function getSortedArr (number) {
    const counts = new Array(2001).fill(0);
    for (let i in number) {
        counts[number[i] + 1000]++;
    }
    const sorted = new Array(number.length);
    let ind = 0;
    for (let i in counts) {
        let cur = i - 1000;
        for (let j = 0; j < counts[i]; j++) {
            sorted[ind++] = cur;
        }
    }
    return sorted;
}
