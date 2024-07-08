import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Main {
	private static class Solution {
		private int[] visited;
		private int counter = 1;
		public void solve(int N, int R, ArrayList<Integer>[] edges) {
			visited = new int[N + 1];
			sortEdges(edges);
			bfs(R, edges);
			printResult();
		}
		
		private void bfs(int R, ArrayList<Integer>[] edges) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(R);
			visited[R] = counter++;
			while (!queue.isEmpty()) {
				int cur = queue.pop();
				for (int i = 0; i < edges[cur].size(); i++) {
					int next = edges[cur].get(i);
					if (visited[next] != 0) continue;
					queue.add(next);
					visited[next] = counter++;
				}
			}
		}
		
		private void sortEdges(ArrayList<Integer>[] edges) {
			for (int i = 1; i < edges.length; i++) {
				edges[i].sort((a, b) -> a - b);
			}
		}
		
		private void printResult() {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < visited.length; i++) {
				sb.append(visited[i]).append('\n');
			}
			System.out.print(sb.toString());
		}
		
	}
	
	public static void main (String[] args) throws IOException{
		int N = readInt();
		int M = readInt();
		int R = readInt();
		ArrayList<Integer>[] edges = (ArrayList<Integer>[]) new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int u = readInt();
			int v = readInt();
			edges[u].add(v);
			edges[v].add(u);
		}
		
		new Solution().solve(N, R, edges);
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
