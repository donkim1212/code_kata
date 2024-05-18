import java.util.HashMap;
import java.lang.Math;

class Solution {
    public int solution(int k, int[] tangerine) {
        if (k == 1) return 1;
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int max = 0;
        
        for (int i = 0; i < tangerine.length; i++) {
            int cur = tangerine[i];
            int count = counts.containsKey(cur) ? counts.get(cur) + 1 : 1;
            if (max < count) max = count;
            counts.put(cur, count);
        }
        
        int[] arr = new int[max + 1];
        for (int i : counts.values()) {
            arr[i]++;
        }
        
        int ret = 0;
        int index = max + 1;
        while (k > 0) {
            int cur = arr[--index];
            if (cur == 0) continue;
            if (index == 1) break;
            int usedKinds = Math.min(Math.max(k / index, 1), cur);
            int usedCount = usedKinds * index;
            k -= usedCount;
            ret += usedKinds;
        }
        
        if (k > 0) ret += k;
        
        return ret;
    }
}