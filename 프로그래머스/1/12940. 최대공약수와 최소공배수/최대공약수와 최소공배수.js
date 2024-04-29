function solution(n, m) {
    // Euclidean
    
    const ret = new Array(2);
    // greatest common divisor
    ret[0] = getGCD(n, m);
    console.log(ret[0]);
    
    // least common multiples
    ret[1] = n * m / ret[0];
    return ret;
}

function getGCD (n, m) {
    let a = Math.max(n, m);
    let b = Math.min(n, m);
    while ((a % b) != 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return b;
}