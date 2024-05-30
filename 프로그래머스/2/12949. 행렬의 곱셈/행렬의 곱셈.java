class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // when matrix A's cols == matrix B's rows
        // matrix AB's rows == matrix A's rows
        // matrix AB's cols == matrix B's cols
        int rows = arr1.length; // A's rows
        int cols = arr2[0].length; // B's cols
        int[][] ret = new int[rows][cols]; // AB with A's rows & B's cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    // AB's element at row i and col j
                    // equals sum of (each element in A's row i multiplied by
                    // corresponding element in B's col j in each rows)
                    // e.g., A = [[1, 4], [3, 1]], B = [[3], [2]]
                    //  then AB = [[1 * 3 + 4 * 2], [3 * 3 + 1 * 2]]
                    //  which is [[11], [11]]
                    ret[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return ret;
    }
}