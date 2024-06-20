import java.io.IOException;

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int max = 0;
    public static void main (String[] args) {
        try {
            init();
            solution();
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void solution () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                findMaxSum (i, j, 1, 0);
                checkTSum (i, j);
            }
        }
    }
    
    private static void checkTSum (int i, int j) {
        int sum;
        if (i > 0 && j > 0 && j < M - 1) {
            sum = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] + arr[i][j + 1];
            if (sum > max) max = sum;
        }
        if (i < N - 1 && j > 0 && j < M - 1) {
            sum = arr[i][j] + arr[i + 1][j] + arr[i][j - 1] + arr[i][j + 1];
            if (sum > max) max = sum;
        }
        if (i > 0 && i < N - 1 && j > 0) {
            sum = arr[i][j] + arr[i - 1][j] + arr[i + 1][j] + arr[i][j - 1];
            if (sum > max) max = sum;
        }
        if (i > 0 && i < N - 1 && j < M - 1) {
            sum = arr[i][j] + arr[i - 1][j] + arr[i + 1][j] + arr[i][j + 1];
            if (sum > max) max = sum;
        }
    }
    
    private static void findMaxSum(int i, int j, int depth, int sum) {
        if (depth == 4) {
            int temp = sum + arr[i][j];
            if (temp > max) max = temp;
            visited[i][j] = false;
            return;
        }
        depth++;
        sum += arr[i][j];
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j]){
            findMaxSum (i - 1, j, depth, sum);
        }
        if (i < N - 1 && !visited[i + 1][j]) {
            findMaxSum (i + 1, j, depth, sum);
        }
        if (j > 0 && !visited[i][j - 1]){
            findMaxSum (i, j - 1, depth, sum);
        }
        if (j < M - 1 && !visited[i][j + 1]){
            findMaxSum (i, j + 1, depth, sum);
        }
        visited[i][j] = false;
    }
    
    private static void init() throws IOException {
        N = readInt();
        M = readInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = readInt();
            }
        }
    }
    
    private static int readInt() throws IOException {
        int c, ret = 0;
        while ((c = System.in.read()) > 47) ret = ret * 10 + c - 48;
        if (c == 13) System.in.read();
        return ret;
    }
}
