import java.lang.StringBuilder;

class Solution {
    StringBuilder sb;
    public String solution(String number, int k) {
        this.sb = new StringBuilder(number);
        int length = sb.length();
        int count = k;
        while (count-- > 0) {
            cut(count, sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    private void cut (int count, int length) {
        char a = sb.charAt(0);
        char b = sb.charAt(count);
        if (a < b) {
            sb.deleteCharAt(0);
            return;
        }
        
        for (int i = count; i < length; i++) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                return;
            }
        }
        
        sb.setLength(length);
    }
}