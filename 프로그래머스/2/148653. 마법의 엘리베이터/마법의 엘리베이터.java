import java.lang.StringBuilder;
class Solution {
    public int solution(int storey) {
        StringBuilder sb = new StringBuilder();
        sb.append(storey);
        int count = 0;
        boolean up = false;
        boolean five = false;
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            int c = sb.charAt(i) - 48 + (up ? 1 : 0);
            if (five && c >= 5) c++;
            five = false;
            if (c > 9) {
                up = true;
                continue;
            }
            if (c > 5) {
                count += 10 - c;
                up = true;
            }
            else {
                if (c == 5) five = true;
                count += c;
                up = false;
            }
        }
        
        if (up) count++;
        
        return count;
    }
}