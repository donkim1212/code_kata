import java.lang.Math;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] ret = new int[(int) (right - left) + 1];
        long cur = left;
        int index = 0;
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Math.max((int) (cur / n), (int) (cur++ % n)) + 1;
        }
        
        return ret;
    }
}