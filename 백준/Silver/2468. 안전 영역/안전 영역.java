import java.io.IOException;
import java.util.HashSet;

public class Main {
	private static class Solution {
		private int[] di = {-1, 1, 0, 0};
		private int[] dj = {0, 0, -1, 1};
		private boolean[][] visited;
		private boolean[][] flooded;
		private int maxCount = 1;
		private int count = 0;
		public void solve(int N, int[][] map, int minHeight, int maxHeight, HashSet<Integer> nums) {
			flooded = new boolean[N][N];
			for (int i = minHeight; i <= maxHeight; i++) {
				if (!nums.contains(i)) continue;
				flood(N, map, i);
				if (count == 0) break;
			}
			System.out.print(maxCount);
		}
		
		private void flood (int N, int[][] map, int height) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= height) flooded[i][j] = true;
				}
			}
			
			visited = new boolean[N][N];
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] || flooded[i][j]) continue;
					explore(map, i, j, height);
					count++;
				}
			}
			if (maxCount < count) maxCount = count;
		}
		
		private void explore(int[][] map, int i, int j, int height) {
			visited[i][j] = true;
			for (int k = 0; k < 4; k++) {
				int ni = i + di[k];
				if (ni < 0 || ni >= map.length) continue;
				int nj = j + dj[k];
				if (nj < 0 || nj >= map.length) continue;
				if (!visited[ni][nj] && !flooded[ni][nj]) explore(map, ni, nj, height);
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		int N = readInt();
		int minHeight = 100;
		int maxHeight = 1;
		HashSet<Integer> nums = new HashSet<Integer>();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = readInt();
				if (map[i][j] > maxHeight) maxHeight = map[i][j];
				if (map[i][j] < minHeight) minHeight = map[i][j];
				nums.add(map[i][j]);
			}
		}
		new Solution().solve(N, map, minHeight, maxHeight, nums);
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
