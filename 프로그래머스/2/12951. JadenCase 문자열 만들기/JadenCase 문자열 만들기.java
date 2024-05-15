import java.lang.StringBuilder;

class Solution {
    private final int DIFF = 'a' - 'A'; // 32
    
    public String solution(String s) {
        StringBuilder ret = new StringBuilder();
        
        char prev = s.charAt(0);
        if (isLowerCase(prev)) prev = toUpperCase(prev);
        ret.append(prev);
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (prev == ' ') { // convert
                if (isLowerCase(c)) c = toUpperCase(c);
            }
            else {
                if (isUpperCase(c)) c = toLowerCase(c);
            }
            prev = c;
            ret.append(c);
        }
        return ret.toString();
    }
    
    private char toLowerCase (char c) {
        int ret = (c == ' ') ? ' ' : c + DIFF;
        return (char) ret;
    }
    
    private char toUpperCase (char c) {
        int ret = c - DIFF;
        return (char) ret;
    }
    
    private boolean isLowerCase(char c) {
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }
    
    private boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }
}