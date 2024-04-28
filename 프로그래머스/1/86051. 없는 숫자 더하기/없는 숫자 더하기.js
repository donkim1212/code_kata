function solution(numbers) {
    let sum = 45;
    for (let i in numbers) {
        sum -= numbers[i];
    }
    return sum;
}