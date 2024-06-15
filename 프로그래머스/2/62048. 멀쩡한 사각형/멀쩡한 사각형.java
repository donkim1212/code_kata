class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        if (w == h) return answer - w;
        
        if (h > w) {
            int tmp = h;
            h = w;
            w = tmp;
        }
        
        return answer - (w + h - getGCD(w, h));
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