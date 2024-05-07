class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int until = 0;
        for (int i = 0 ; i < section.length; i++) {
            if (until < section[i]) {
                count++;
                until = section[i] + m - 1;
            }
        }
        return count;
    }
}