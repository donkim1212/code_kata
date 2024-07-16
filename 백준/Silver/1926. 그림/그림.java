import java.io.IOException;
import java.lang.Math;
import java.lang.StringBuilder;

public class Main {
    private static class Solution {
        private boolean[][] visited;
        private boolean[][] arr;
        private int count = 0;
        private int maxSize = 0;
        public void solve(int n, int m, boolean[][] arr) {
        	this.arr = arr;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++){
                    if (visited[i][j] || !arr[i][j]) continue;
                    maxSize = Math.max(dfs(1, i, j), maxSize);
                    count++;
                }
            }
            printResult();
        }
        
        private int dfs (int count, int i, int j) {
        	visited[i][j] = true;
            
            if (i - 1 >= 0 && arr[i - 1][j] && !visited[i - 1][j]) count += dfs(1, i - 1, j);
            if (i + 1 < arr.length && arr[i + 1][j] && !visited[i + 1][j]) count += dfs(1, i + 1, j);
            if (j - 1 >= 0 && arr[i][j - 1] && !visited[i][j - 1]) count += dfs(1, i, j - 1);
            if (j + 1 < arr[0].length && arr[i][j + 1] && !visited[i][j + 1]) count += dfs(1, i, j + 1);
            
            return count;
        }
        
        private void printResult() {
            StringBuilder sb = new StringBuilder();
            sb.append(count).append('\n').append(maxSize);
            System.out.print(sb.toString());
        }
    }
    
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (readInt() == 0) continue;
                arr[i][j] = true;
            }
        }
        new Solution().solve(n, m, arr);
    }
    
    private static int readInt() throws IOException {
        int c, ret = 0;
        while ((c = System.in.read()) > 47) {
            ret = 10 * ret + c - 48;
        }
        if (c == 13) System.in.read();
        return ret;
    }
}