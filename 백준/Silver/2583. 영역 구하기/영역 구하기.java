import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static class Solution {
		private int[] dx = new int[] {1, -1, 0, 0};
		private int[] dy = new int[] {0, 0, 1, -1};
		private boolean[][] visited;
		ArrayList<Integer> results = new ArrayList<Integer>();
		private StringBuilder sb = new StringBuilder();
		public void solve(int M, int N, boolean[][] grid) {
			this.visited = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j< N; j++) {
					if (visited[i][j]) continue;
					if (grid[i][j]) continue;
					results.add(dfs(i, j, grid, 0));
				}
			}
			print();
		}
		
		private int dfs (int y, int x, boolean[][] grid, int count) {
			count++;
			visited[y][x] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (visitable(ny, nx, grid)) {
					count = dfs(ny, nx, grid, count);
				}
			}
			return count;
		}
		
		private boolean visitable(int y, int x, boolean[][] grid) {
			if (x >= grid[0].length || x < 0 || y >= grid.length || y < 0) return false;
			if (visited[y][x]) return false;
			if (grid[y][x]) return false;
			return true;
		}
		
		private void print() {
			sb.append(results.size()).append('\n');
			results.sort((a, b) -> a - b);
			for (int i = 0; i < results.size(); i++) {
				sb.append(results.get(i)).append(' ');
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void main (String[] args) throws IOException {
		int M = readInt(); // y
		int N = readInt(); // x
		int K = readInt();
		boolean[][] grid = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			int x1 = readInt();
			int y1 = readInt();
			int x2 = readInt();
			int y2 = readInt();
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					grid[y][x] = true;
				}
			}
		}
		new Solution().solve(M, N, grid);
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
