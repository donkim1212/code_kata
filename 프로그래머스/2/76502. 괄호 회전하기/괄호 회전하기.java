import java.lang.StringBuilder;

class Solution {
    private StringBuilder sb = new StringBuilder();
    private StringBuilder st = new StringBuilder();
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;
        sb.append(s);
        int end = findFirstClosing(0); // find first closing bracket
        while (end >= 0) { // #loop
            rotate(end); // rotate
            if (tryClose(sb.length() - 1)) end = findFirstClosing(0); // close
            else return 0;
        } // #loop end
        
        return sb.length();
    }
    
    private boolean tryClose(int closing) {
        st.setLength(0);
        st.append(sb.charAt(closing));
        
        while (st.length() > 0) {
            if (--closing < 0) break;
            char cur = sb.charAt(closing);
            if (cur == '.') continue;
            if (isClosing(cur)) st.append(cur);
            else {
                int last = st.length() - 1;
                if (canClose(cur, st.charAt(last))) st.setLength(last);
                else return false;
            }
        }
        
        sb.replace(closing, sb.length(), ".");
        return st.length() == 0;
    }
    
    private void rotate (int endIndex) {
        int newStart = endIndex + 1;
        if (newStart == sb.length()) return;
        String sub = sb.substring (newStart, sb.length());
        sb.setLength(newStart);
        sb.insert(0, sub);
    }
    
    private int findFirstClosing(int start) {
        for (int i = start; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (isClosing(c)) return i;
        }
        return -1;
    }
    
    private boolean canClose (char opening, char closing) {
        if (opening + 1 == closing || opening + 2 == closing) return true;
        else return false;
    }   
    
    private boolean isClosing (char c) {
        if (c == '}' || c == ']' || c == ')') return true;
        return false;
    }
}