class Solution {
    private int[] counts = new int[10001];
    boolean[] hasTopping = new boolean[10001];
    
    public int solution(int[] topping) {
        int kinds = 0;
        for (int i = 0; i < topping.length; i++) {
            if (counts[topping[i]]++ == 0) kinds++;
        }
        
        int bKinds = kinds;
        int aKinds = 0;
        int ret = 0;
        
        for (int i = 0; i < topping.length; i++) {
            counts[topping[i]]--;
            if (!hasTopping[topping[i]]) {
                hasTopping[topping[i]] = true;
                aKinds++;
            }
            if (counts[topping[i]] == 0) bKinds--;
            if (aKinds == bKinds) ret++;
            else if (aKinds > bKinds) break;
        }
        
        return ret;
    }
}