import java.lang.StringBuilder;
class Solution {
    public String solution(String s, String skip, int index) {
        // ASCII
        // 'a' = 97, 'z' = 122
        StringBuilder ret = new StringBuilder();
        boolean[] check = new boolean[123];
        for (int i = 0; i < skip.length(); i++) check[skip.charAt(i)] = true;
        
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            int count = index;
            while (count > 0) {
                if (++cur > 122) cur = 97;
                if (check[cur]) continue;
                count--;
            }
            ret.append((char) cur);
        }
        
        return ret.toString();
    }
}