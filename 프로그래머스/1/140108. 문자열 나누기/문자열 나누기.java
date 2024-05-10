class Solution {
    public int solution(String s) {
        return splitCounter(s, 0);
    }
    
    private int splitCounter(String s, int idx) {
        if (idx >= s.length()) return 0;
        char first = s.charAt(idx);
        int sameCount = 1;
        for (int i = idx + 1; i < s.length(); i++) {
            if (s.charAt(i) == first) sameCount++;
            else sameCount--;
            if (sameCount == 0) return 1 + splitCounter(s, i + 1);
        }
        return 1;
    }
}