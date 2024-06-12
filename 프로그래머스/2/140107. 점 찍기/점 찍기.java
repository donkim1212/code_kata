import java.lang.Math;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int i = 0;  
        long dist = (long) d;
        long ak;
        while ((ak = i++ * k) <= d) {
            answer++;
            long maxY = (long) Math.sqrt(dist * dist - ak * ak);
            answer += maxY / k;
        }
        return answer;
    }
}