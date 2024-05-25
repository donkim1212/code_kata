import java.util.HashMap;

class Solution {
    private HashMap<Character, Integer> map = new HashMap<>();
    public int solution(String word) {
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        int[] inc = new int[5];
        inc[inc.length - 1] = 1;
        for (int i = inc.length - 2; i >= 0; i--) {
            inc[i] = inc[i + 1] * 5 + 1;
        }
        
        int ret = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur = map.get(word.charAt(i));
            ret += cur * inc[i] + 1;
        }
        return ret;
    }
}