import java.util.ArrayList;
import java.lang.Math;

class Solution {
    private boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        visited = new boolean[n + 1];
        int ret = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            visited[v1] = true;
            visited[v2] = true;
            int sum = dfs(wires, v1);
            int other = n - sum;
            int diff = Math.abs(other - sum);
            if (diff < ret) ret = diff;
            visited[v1] = false;
            visited[v2] = false;
        }
        return ret;
    }
    
    private int dfs (int[][] wires, int index) {
        int sum = 1;
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            if (v1 == index && !visited[v2]) {
                visited[v2] = true;
                sum += dfs(wires, v2);
                visited[v2] = false;
            }
            if (v2 == index && !visited[v1]) {
                visited[v1] = true;
                sum += dfs(wires, v1);
                visited[v1] = false;
            }
        }
        return sum;
    }
}