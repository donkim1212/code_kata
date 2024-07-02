import java.util.Comparator;
import java.util.Arrays;
import java.lang.Math;

class Solution {
    private class RowComparator implements Comparator<int[]> {
        private int col = 0;
        public RowComparator (int col) {
            this.col = col - 1;
        }
        @Override
        public int compare (int[] a, int[] b) {
            int ret = a[col] - b[col];
            if (ret == 0) return b[0] - a[0];
            return ret;
        }
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new RowComparator(col));
        int actualRowBegin = row_begin - 1;
        int actualRowEnd = row_end - 1;
        int ret = 0;
        for (int i = actualRowBegin; i <= actualRowEnd; i++) {
            int S_i = 0;
            for (int j = 0; j < data[i].length; j++) {
                S_i += data[i][j] % (i + 1);
            }
            ret = bitwiseXOR(ret, S_i);
        }
        return ret;
    }
    
    private int bitwiseXOR (int a, int b) {
        int max = Math.max(a, b);
        int pow = 0;
        int ret = 0;
        int bin;
        while ((bin = (int) Math.pow(2, pow++)) <= max) {
            if ((bin & a) != (bin & b)) {
                ret += bin;
            }
        }
        return ret;
    }
}