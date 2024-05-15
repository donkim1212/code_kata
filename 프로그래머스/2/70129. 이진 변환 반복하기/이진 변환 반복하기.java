import java.lang.StringBuilder;

class Solution {
    private int zeroesRemoved = 0;
    private int conversionCount = 0;
    
    public int[] solution(String s) {
        binaryConversion(s);
        return new int[] {conversionCount, zeroesRemoved};
    }
    
    private void binaryConversion (String s) {
        while (s.length() > 1) {
            s = toBinary(removeZeroes(s));
        }
    }
    
    private String toBinary (int n) {
        conversionCount++;
        if (n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
    
    private int removeZeroes (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') zeroesRemoved++;
            else sb.append(c);
        }
        return sb.length();
    }
}