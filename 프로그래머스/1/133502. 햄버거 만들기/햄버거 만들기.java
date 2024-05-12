import java.lang.StringBuilder;

class Solution {
    public int solution(int[] ingredients) {
        int start = findFirstBreadIndex(ingredients);
        if (start == -1) return 0;
        return getBurgerCountSB(ingredients, start);
    }
    
    private int getBurgerCountSB (int[] ingredients, int start) {
        StringBuilder sb = new StringBuilder();
        int burgerCount = 0;
        sb.append(ingredients[start]);
        for (int i = start + 1; i < ingredients.length; i++) {
            int cur = ingredients[i];
            if (sb.length() > 2) {
                int index = sb.length() - 1;
                if (cur == 1
                     && sb.charAt(index--) == '3'
                     && sb.charAt(index--) == '2'
                     && sb.charAt(index) == '1') {
                    sb.delete(index, sb.length());
                    burgerCount++;
                    continue;
                }
            } 
            sb.append(cur);
        }
        return burgerCount;
    }
    
    private int findFirstBreadIndex (int[] ingredients) {
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == 1) return i;
        }
        return -1;
    }
}