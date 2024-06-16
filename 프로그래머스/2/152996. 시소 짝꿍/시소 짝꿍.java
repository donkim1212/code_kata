import java.util.HashMap;
import java.util.HashSet;

class Solution {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private HashSet<Integer> set = new HashSet<Integer>();
    public long solution(int[] weights) {
        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
            set.add(weights[i]);
        }
        
        long answer = 0;
        for (int weight : set) {
            long cur = (long) map.get(weight);
            answer += cur * (cur - 1) / 2;
            
            // 4 2
            int opposite = map.getOrDefault(weight * 2, 0); 
            answer += cur * opposite;
            
            // 4 3, 3 2
            for (int i = 4; i >= 3; i--) {
                int tmp = weight * i;
                if (tmp % (i - 1) == 0) {
                    opposite = map.getOrDefault(tmp / (i - 1), 0);
                    answer += cur * opposite;
                }
            }
        }
        return answer;
    }
}