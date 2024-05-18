import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        if (k == 1) return 1;
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < tangerine.length; i++) {
            int cur = tangerine[i];
            int count = counts.containsKey(cur) ? counts.get(cur) + 1 : 1;
            counts.put(cur, count);
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>(counts.values());
        Collections.sort(list);
        
        int ret = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int cur = list.get(i);
            k -= cur;
            ret++;
            if (k <= 0) break;
        }
        
        return ret;
    }
}