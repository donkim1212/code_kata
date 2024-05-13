class Solution {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    
    public String solution(String s) {
        findMinMax(s, 0);
        return min + " " + max;
    }
    
    private void findMinMax(String s, int i) {
        // ASCII: '0' = 48
        int mult = (s.charAt(i) == '-') ? -1 : 1;
        int ret = 0;
        if (mult == -1) i += 1;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == ' ') break;
            ret = ret * 10 + c - 48;
        }
        ret *= mult;
        if (ret < min) min = ret;
        if (ret > max) max = ret;
        if (i < s.length()) findMinMax(s, i);
    }
}