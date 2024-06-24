class Solution {
    private int[] counts = new int[] { 0, 0 };
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return counts;
    }
    
    private void quad(int[][] arr, int iStart, int jStart, int length) {
        if (length == 1) {
            counts[arr[iStart][jStart]]++;
            return;
        }
        int iEnd = iStart + length - 1;
        int jEnd = jStart + length - 1;
        int target = arr[iStart][jStart];
        boolean mismatch = false;
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                if (arr[i][j] != target) {
                    mismatch = true;
                    break;
                }
            }
            if (mismatch) break;
        }
        if (!mismatch) {
            counts[target]++;
            return;
        }
        
        int nextLength = length / 2;
        quad(arr, iStart, jStart, nextLength);
        quad(arr, iStart, jStart + nextLength, nextLength);
        quad(arr, iStart + nextLength, jStart, nextLength);
        quad(arr, iStart + nextLength, jStart + nextLength, nextLength);
    }
}