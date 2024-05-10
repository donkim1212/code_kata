class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // ASCII
        // 'A' = 65, 'Z' = 90
        int[] counts = new int[91];
        for (int i = 65; i < 91; i++) {
            counts[i] = Integer.MAX_VALUE;
        }
        
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                int cur = s.charAt(i);
                if (counts[cur] > i) counts[cur] = i + 1;
            }
        }
        
        int[] ret = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String s = targets[i];
            for (int j = 0; j < s.length(); j++) {
                int cur = s.charAt(j);
                if (counts[cur] > 100) {
                    ret[i] = -1;
                    break;
                }
                ret[i] += counts[cur];
            }
        }
        return ret;
    }
}