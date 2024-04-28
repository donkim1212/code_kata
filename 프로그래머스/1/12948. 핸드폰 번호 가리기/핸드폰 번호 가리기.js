function solution(phone_number) {
    let ret = "****************";
    return ret.substring(0, phone_number.length - 4).concat(phone_number.slice(-4));
}