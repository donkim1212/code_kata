import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;
import java.lang.StringBuilder;

class Solution {
    private class StringIntComparator implements Comparator<String> {
        @Override
        public int compare (String a, String b) {
            String temp = a;
            a = a + b;
            b = b + temp;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) < b.charAt(i)) return 1;
                else if (a.charAt(i) > b.charAt(i)) return -1;
            }
            return 0;
        }
    }
    public String solution(int[] numbers) {
        String[] converted = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            converted[i] = "" + numbers[i];
        }
        
        Arrays.sort(converted, new StringIntComparator());
        
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < converted.length; i++) {
            ret.append(converted[i]);
        }
        
        int i = 0;
        boolean found = false;
        while (i < ret.length() && ret.charAt(i) == '0') {
            found = true;
            i++;
        }
        
        if (found) ret.delete(0, i);
        if (ret.length() == 0) return "0";
        
        return ret.toString();
    }
}