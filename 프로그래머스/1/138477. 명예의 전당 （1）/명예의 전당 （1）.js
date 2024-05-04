function solution(k, score) {
    const hof = new Array(2001).fill(0);
    const ret = new Array(score.length);
    let min = score[0];
    hof[score[0]]++;
    ret[0] = min;
    for (let i = 1; i < Math.min(k, score.length); i++) {
        hof[score[i]]++;
        if (score[i] < min) min = score[i];
        ret[i] = min;
    }
    
    for (let i = k; i < score.length; i++) {
        if (score[i] > min) {
            hof[score[i]]++;
            if (hof[min]-- <= 1) {
                for (let j = min + 1; j < hof.length; j++) {
                    if (hof[min = j] > 0) break;
                }
            }
        }
        ret[i] = min;
    }
    return ret;
}