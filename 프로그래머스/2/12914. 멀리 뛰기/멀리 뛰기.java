import java.lang.Math;

class Solution {
    private final int DIV = 1234567;
    public long solution(int n) {
        int prev = 1;
        if (n == 1) return prev;
        int cur = 2;
        while (n-- > 2) {
            int temp = prev;
            prev = cur;
            cur = (temp + cur) % DIV;
        }
        return (long) cur;
    }
}