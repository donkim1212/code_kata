import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static class Solution {
		private int[] sequence;
		private int count = 1;
		
		public void solve(int N, int M, int R, ArrayList<Integer>[] list) {
			sequence = new int[N + 1];
			dfs(R, list);
			for (int i = 1; i <= N; i++) {
				System.out.println(sequence[i]);
			}
		}
		
		private void dfs (int cur, ArrayList<Integer>[] list) {
			sequence[cur] = count++;
			Collections.sort(list[cur]);
			for (int i = 0; i < list[cur].size(); i++) {
				if (sequence[list[cur].get(i)] != 0) continue;
				dfs(list[cur].get(i), list);
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		int N = readInt();
		int M = readInt();
		int R = readInt();
		ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[N + 1];
		list[0] = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			int a = readInt();
			int b = readInt();
			list[a].add(b);
			list[b].add(a);
		}
		new Solution().solve(N, M, R, list);
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
