import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

public class Main {
	private static class Node implements Comparable<Node>{
		public int index = 0;
		public int depth = 0;
		
		public Node (int index, int depth) {
			this.index = index;
			this.depth = depth;
		}

		@Override
		public int compareTo(Node other) {
			if (this.depth == other.depth) {
				return other.index - this.index;
			}
			return other.depth - this.depth;
		}
	}
	
	private static class Solution {
		private int N, M, R;
		private ArrayList<Integer>[] list;
		private PriorityQueue<Node> pq = new PriorityQueue<Node>();
		private int[] visitedAt;
		private int count = 1;
		public Solution (int N, int M, int R, ArrayList<Integer>[] list) {
			this.N = N;
			this.M = M;
			this.R = R;
			this.list = list;
			this.visitedAt = new int[N + 1];
		}
		public void solve() {
			pq.add(new Node(R, 1));
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visitedAt[cur.index] == 0) visitedAt[cur.index] = count++;
				for (int i = 0; i < list[cur.index].size(); i++) {
					int v = list[cur.index].get(i);
					if (visitedAt[v] != 0) continue;
					pq.add(new Node(v, cur.depth + 1));
				}
			}
			printVisitedAt();
		}
		
		private void printVisitedAt() {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < visitedAt.length; i++) {
				sb.append(visitedAt[i]);
				sb.append('\n');
			}
			System.out.print(sb.toString());
		}
	}
	
	public static void main (String[] args) throws IOException {
		int N = readInt();
		int M = readInt();
		int R = readInt();
		ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int u = readInt();
			int v = readInt();
			list[u].add(v);
			list[v].add(u);
		}
		new Solution(N, M, R, list).solve();
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
