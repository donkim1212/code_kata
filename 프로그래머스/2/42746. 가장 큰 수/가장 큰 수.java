import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;
import java.lang.StringBuilder;

class Solution {
    private class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer a, Integer b) {
            if (a == b) return 0;
            int temp = a;
            int aLen = a == 0 ? 1 : (int) Math.log10(a) + 1;
            int bLen = b == 0 ? 1 : (int) Math.log10(b) + 1;
            a = a * (int) Math.pow(10, bLen) + b;
            b = b * (int) Math.pow(10, aLen) + temp;
            return b - a;
        }
    }
    public String solution(int[] numbers) {
        Integer[] converted = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) converted[i] = numbers[i];
        Arrays.sort(converted, new IntegerComparator());
        
        if (converted[0] == 0) return "0";
        StringBuilder ret = new StringBuilder();
        for (int n : converted) ret.append(n);
        
        return ret.toString();
    }
}