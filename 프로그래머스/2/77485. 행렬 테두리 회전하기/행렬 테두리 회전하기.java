class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] table = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = i * columns + 1 + j;
            }
        }
        
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int x1y1 = table[x1][y1];
            int min = x1y1;
            
            // x1y1 ~ x2y1
            for (int i = x1; i < x2; i++) {
                table[i][y1] = table[i + 1][y1];
                if (table[i][y1] < min) min = table[i][y1];
            }
            // x2y1 ~ x2y2
            for (int i = y1; i < y2; i++) {
                table[x2][i] = table[x2][i + 1];
                if (table[x2][i] < min) min = table[x2][i];
            }
            // x2y2 ~ x1y2
            for (int i = x2; i > x1; i--) {
                table[i][y2] = table[i - 1][y2];
                if (table[i][y2] < min) min = table[i][y2];
            }
            // x1y2 ~ x1y1
            for (int i = y2; i > y1 + 1; i--) {
                table[x1][i] = table[x1][i - 1];
                if (table[x1][i] < min) min = table[x1][i];
            }
            table[x1][y1 + 1] = x1y1;
            
            answer[index++] = min;
        }
        
        return answer;
    }
}