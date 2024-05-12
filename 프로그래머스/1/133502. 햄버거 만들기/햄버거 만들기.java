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
                if (cur == 1
                     && sb.charAt(sb.length() - 1) == '3'
                     && sb.charAt(sb.length() - 2) == '2'
                     && sb.charAt(sb.length() - 3) == '1') {
                    sb.setLength(sb.length() - 3);
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