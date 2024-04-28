function solution(price, money, count) {
    let spent = (price + price * count) * (count / 2);
    return (money - spent >= 0) ? 0 : Math.abs(money - spent);
}