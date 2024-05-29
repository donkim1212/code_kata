import java.lang.Math;
import java.lang.StringBuilder;

class Solution {
    StringBuilder sb;
    public String solution(String number, int k) {
        this.sb = new StringBuilder(number);
        int length = sb.length();
        int count = k;
        while (count-- > 0) {
            cut(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    private void cut (int length) {
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                return;
            }
        }
        sb.setLength(length);
    }
}