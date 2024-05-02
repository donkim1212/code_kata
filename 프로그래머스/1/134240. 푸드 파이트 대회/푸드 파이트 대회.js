function solution(food) {
    let ret = "";
    let reverse = "";
    for (let i = 1; i < food.length; i++) {
        if (food[i] <= 1) continue;
        for (let j = 0; j < Math.trunc(food[i] / 2); j++) {
            ret += i;
            reverse = i + reverse;
        }
    }
    return ret + "0" + reverse;
}