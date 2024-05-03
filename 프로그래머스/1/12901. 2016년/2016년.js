function solution(a, b) {
    const DOW = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
    const DIV = 86400000; // 24 * 60 * 60 * 1000
    const INIT_DOW = 5;
    let start = Date.parse("2016-1-1");
    let end = Date.parse("2016-" + a + "-" + b);
    let passed = Math.round((end - start) / DIV);
    let dowInd = (passed + INIT_DOW) % 7;
    return DOW[dowInd];
}