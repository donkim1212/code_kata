import java.io.IOException;
import java.lang.Math;
import java.lang.StringBuilder;

public class Main {
    private static class Solution {
        private boolean[][] visited;
        private int[] dy = new int[]{ -1, 1, 0, 0 };
        private int[] dx = new int[]{ 0, 0, -1, 1};
        private int count = 0;
        private int maxSize = 0;
        public void solve(int n, int m, boolean[][] arr) {
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++){
                    if (visited[i][j] || !arr[i][j]) continue;
                    maxSize = Math.max(dfs(1, i, j, arr), maxSize);
                    count++;
                }
            }
            printResult();
        }
        
        private int dfs (int count, int i, int j, boolean[][] arr) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = i + dy[k];
                int nj = j + dx[k];
                if (ni >= 0 && ni < arr.length && nj >= 0 && nj < arr[0].length) {
                    if (visited[ni][nj] || !arr[ni][nj]) continue;
                    count += dfs(1, ni, nj, arr);
                }
            }
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