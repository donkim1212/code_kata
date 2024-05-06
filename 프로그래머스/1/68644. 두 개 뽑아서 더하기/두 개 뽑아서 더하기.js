function solution(numbers) {
    const initCounts = new Array(101).fill(0);
    const retCounts = new Array(201).fill(0);
    let count = 0;
    for (let i = 0; i < numbers.length; i++) {
        if (initCounts[numbers[i]]++ == 1 && retCounts[numbers[i] * 2] < 1) {
            retCounts[numbers[i] + numbers[i]]++;
            count++;
        }
        else if (initCounts[numbers[i]] == 1) {
            for (let j = i - 1; j >= 0; j--) {
                if (retCounts[numbers[i] + numbers[j]]++ == 0) count++;
            }
        }
    }
    let ret = new Array(count);
    let ind = 0;
    for (let i = 0; i < retCounts.length; i++) {
        if (retCounts[i] > 0) ret[ind++] = i;
    }
    return ret;
}