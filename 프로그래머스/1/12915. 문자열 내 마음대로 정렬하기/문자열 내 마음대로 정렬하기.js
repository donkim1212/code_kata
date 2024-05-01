function solution(strings, n) {
    return strings.sort((a, b) => {
        if (a[n] == b[n]) {
            if (a == b) return 0;
            for (let i = 0; i < Math.min(a.length, b.length); i++) {
                if (a[i] < b[i]) return -1;
                else if (a[i] > b[i]) return 1;
            }
            return a.length < b.length ? -1 : 1;
        }
        return a[n] < b[n] ? -1 : 1;
    });
}