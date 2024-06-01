import java.lang.Math;

class Solution {
    public long[] solution(long[] numbers) {
        long[] ret = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            ret[i] = findNearest(numbers[i]);
        }
        return ret;
    }
    
    private long findNearest (long number) {
        long ret = number + 1;
        if (number % 2 == 0) return ret;
        int count = 0;
        while (number % 2 != 0) {
            count++;
            number /= 2;
        }
        if (count-- == 1) return ret;
        for (int i = 0; i < count; i++) {
            ret += Math.pow(2, i);
        }
        return ret;
    }
}