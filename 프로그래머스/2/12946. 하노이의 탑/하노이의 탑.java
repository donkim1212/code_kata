class Solution {
    private int[][] result;
    private int index = 0;
    public int[][] solution(int n) {
        result = new int[getResultSize(n)][2];
        
        move(n, 1, 2, 3);
        
        return result;
    }
    
    private void move (int n, int originIndex, int midIndex, int destIndex) {
        if (n == 1) {
            result[index++] = new int[] { originIndex, destIndex };
            return;
        }
        else {
            move (n - 1, originIndex, destIndex, midIndex);
            move (1, originIndex, midIndex, destIndex);
            move (n - 1, midIndex, originIndex, destIndex);
        }
        
    }
    
    private int getResultSize (int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret * 2 + 1;
        }
        return ret;
    }
}