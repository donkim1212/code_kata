function solution(num) {
    if (num == 1) return 0;
    let count = 0;
    while (num > 1) {
        if (num & 1) num = num * 3 + 1;
        else num = num / 2;
        if (++count >= 500) return -1;
    }
    return count;
}