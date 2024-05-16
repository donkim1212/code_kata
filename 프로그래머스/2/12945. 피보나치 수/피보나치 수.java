class Solution {
    private final int div = 1234567;
    
    public int solution(int n) {
        int index = 2;
        int prev = 0;
        int cur = 1;
        while (index++ <= n) {
            int temp = (cur + prev) % div;
            prev = cur;
            cur = temp;
        }
        return cur % div;
    }
}