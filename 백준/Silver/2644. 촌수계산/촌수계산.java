import java.io.IOException;

public class Main {
	private static class Solution {
		private int[] visited;
		private int dest;
		public void solve(int n, int a, int b, boolean[][] edges) {
			this.visited = new int[n + 1];
			this.dest = b;
			if (!dfs(0, a, edges)) {
				System.out.println(-1);
			}
			else {
				System.out.println(visited[b]);
			}
		}
		
		private boolean dfs(int depth, int cur, boolean[][] edges) {
			visited[cur] = depth;
			if (cur == dest) return true;
			for (int i = 1; i < edges[cur].length; i++) {
				if (visited[i] != 0) continue;
				if (!edges[cur][i]) continue;
				if (dfs(depth + 1, i, edges)) return true;
			}
			return false;
		}
	}
	
	public static void main (String[] args) throws IOException {
		int n = readInt();
		int a = readInt();
		int b = readInt();
		int m = readInt();
		boolean[][] edges = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int x = readInt();
			int y = readInt();
			edges[x][y] = true;
			edges[y][x] = true;
		}
		
		new Solution().solve(n, a, b, edges);
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
