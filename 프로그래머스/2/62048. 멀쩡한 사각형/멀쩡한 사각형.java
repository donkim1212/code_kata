import java.lang.Math;

class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        if (w == h) return answer - w;
        // rotate to fit the function's requirement
        int max = Math.max(w, h);
        int min = Math.min(w, h);
        
        return answer - (min + max - getGCD(max, min));
    }
    
    private int getGCD (int a, int b) {
        int leftover;
        while (b != 0) {
            leftover = a % b;
            a = b;
            b = leftover;
        }
        return a;
    }
}