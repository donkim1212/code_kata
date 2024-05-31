import java.util.HashMap;
import java.util.Collections;

class Solution {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public int solution(String[][] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            String cur = clothes[i][1];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        
        Object[] arr = map.values().toArray();
        
        int ret = 1;
        for (int i = 0; i < arr.length; i++) {
            ret *= (Integer) arr[i] + 1;
        }
        
        return ret - 1;
    }
}