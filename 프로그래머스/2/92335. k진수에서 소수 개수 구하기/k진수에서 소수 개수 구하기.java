import java.lang.Math;

class Solution {
    public int solution(int n, int k) {
        int count = 0;
        long converted = 0;
        long mult = 1;
        while (n > 0) {
            long cur = n % k;
            n /= k;
            if (cur == 0) {
                if (isPrime(converted)) count++;
                converted = 0;
                mult = 1;
                continue;
            }
            converted += cur * mult;
            mult *= 10;
        }
        
        if (isPrime(converted)) count++;
        
        return count;
    }
    
    private boolean isPrime(long number) {
        if (number <= 1) return false;
        long sqrt = (long) Math.sqrt(number);
        for (long i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}