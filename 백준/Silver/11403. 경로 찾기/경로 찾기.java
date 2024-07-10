import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
	private static class Solution {
		StringBuilder sb = new StringBuilder();
		public void solve(int N, int[][] edges) {
			floidWarshall(N, edges);
			printArray(edges);
		}
		
		private void floidWarshall (int N, int[][] edges) {
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (edges[i][k] == 1 && edges[k][j] == 1) {
							edges[i][j] = 1;
						}
					}
				}
			}
		}
		
		private void printArray(int[][] edges) {
			for (int i = 0; i < edges.length; i++) {
				for (int j = 0; j < edges[i].length; j++) {
					sb.append(edges[i][j]).append(' ');
				}
				sb.replace(sb.length() - 1, sb.length(), "\n");
			}
			System.out.print(sb.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[][] edges = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				edges[i][j] = readInt();
			}
		}
		new Solution().solve(N, edges);
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
