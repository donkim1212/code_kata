function solution(cards1, cards2, goal) {
    let ind1 = 0;
    let ind2 = 0;
    let result = "Yes";
    for (let i = 0; i < goal.length; i++) {
        if (cards1[ind1] == goal[i]) {
            ind1++;
            continue;
        }
        else if (cards2[ind2] == goal[i]) {
            ind2++;
            continue;
        }
        else {
            result = "No";
            break;
        }
    }
    return result;
}