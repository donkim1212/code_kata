class Solution {
    private int[][] result;
    private int index = 0;
    public int[][] solution(int n) {
        result = new int[getResultSize(n)][2];
        
        move(n, 1, 2, 3);
        
        return result;
    }
    
    private void move (int n, int origin, int mid, int dest) {
        if (n == 1) {
            result[index][0] = origin;
            result[index++][1] = dest;
            return;
        }
        move (n - 1, origin, dest, mid);
        move (1, origin, mid, dest);
        move (n - 1, mid, origin, dest);
        
    }
    
    private int getResultSize (int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret * 2 + 1;
        }
        return ret;
    }
}