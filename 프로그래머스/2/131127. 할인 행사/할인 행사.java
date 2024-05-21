import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> indices = new HashMap<String, Integer>();
        
        int ret = 0;
        for (int i = 0; i < want.length; i++) {
            indices.put(want[i], i);
        }
        
        for (int i = 0; i < 10; i++) {
            if (indices.containsKey(discount[i])) number[indices.get(discount[i])]--;
        }
        
        if (check(number)) ret++;
        
        for (int i = 10; i < discount.length; i++) {
            String prev = discount[i - 10];
            if (indices.containsKey(prev)) number[indices.get(prev)]++;
            if (indices.containsKey(discount[i])) {
                int curIdx = indices.get(discount[i]);
                if (--number[curIdx] == 0 && check(number)) ret++; 
            }
        }
        return ret;
    }
    
    private boolean check(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) return false;
        }
        return true;
    }
}