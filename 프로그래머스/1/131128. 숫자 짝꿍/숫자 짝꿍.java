import java.lang.StringBuilder;

class Solution {
    public String solution(String X, String Y) {
        // ASCII
        // '0' = 48, '9' = 57
        StringBuilder[] countsX = new StringBuilder[58];
        StringBuilder[] countsY = new StringBuilder[58];
        for (int i = 48; i <= 57; i++) {
            // init with StringBuilder
            countsX[i] = new StringBuilder("");
            countsY[i] = new StringBuilder("");
        }
        for (int i = 0; i < X.length(); i++) { // X
            char curX = X.charAt(i);
            countsX[curX].append(curX);
        }
        for (int i = 0; i < Y.length(); i++) { // Y
            char curY = Y.charAt(i);
            countsY[curY].append(curY);
        }
        
        // ------------------------
        
        StringBuilder ret = new StringBuilder("");
        for (int i = 57; i >= 49; i--) { // 9 ~ 1
            if (countsX[i].length() < countsY[i].length()) ret.append(countsX[i]);
            else ret.append(countsY[i]);
        }
        
        if (ret.toString().equals("")) {
            if (Math.min(countsX[48].length(), countsY[48].length()) == 0) return "-1";
            return "0";
        }
        if (countsX[48].length() < countsY[48].length()) ret.append(countsX[48]);
        else ret.append(countsY[48]);
        return ret.toString();
    }
}