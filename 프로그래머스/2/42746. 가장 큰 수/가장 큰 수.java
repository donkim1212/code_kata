import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;
import java.lang.StringBuilder;

class Solution {
    private class IntegerComparator implements Comparator<Integer> {
        private final int SHIFT = 14;
        @Override
        public int compare (Integer a, Integer b) {
            if (a == b) return 0;
            int temp = a;
            int aLen = (int) Math.max((Math.log10(a)), 0) + 1;
            int bLen = (int) Math.max((Math.log10(b)), 0) + 1;
            a = a * (int) Math.pow(10, bLen) + b;
            b = b * (int) Math.pow(10, aLen) + temp;
            return b - a;
        }
    }
    public String solution(int[] numbers) {
        Integer[] converted = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) converted[i] = numbers[i];
        Arrays.sort(converted, new IntegerComparator());
        
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < converted.length; i++) {
            if (ret.length() == 0 && converted[i] == 0) continue;
            ret.append(converted[i]);
        }
        
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}