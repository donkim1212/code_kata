class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 1;
        for (int i = 2; i <= number; i++) {
            int cur = getDivisorCount(i);
            if (cur > limit) sum += power;
            else sum += cur;
        }
        return sum;
    }
    
    private int getDivisorCount (int n) {
        int count = 2; // 1, self
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) count += 2;
        }
        if (Math.sqrt(n) % 1 == 0) count++;
        return count;
    }
}