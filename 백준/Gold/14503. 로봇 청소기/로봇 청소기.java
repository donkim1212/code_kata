import java.io.IOException;

public class Main {
	private static class Solution {
		private int[] dr = new int[] {-1, 0, 1, 0};
		private int[] dc = new int[] {0, 1, 0, -1};
		
		private int[][] arr;
		private boolean[][] isCleaned;
		
		private int count, r, c, d;
		
		public int solve(int N, int M, int r, int c, int d, int[][] arr) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.arr = arr;
			this.isCleaned = new boolean[N][M];
			this.count = 0;
			
			while (true) {
				clean();
				if (lookAround()) {
					rotateAndMove();
				}
				else {
					if (!move(getBackwardIndex())) break;
				}
			}
			
			return count;
		}
		
		private void rotateAndMove() {
			int rotationCount = 3;
			while (rotationCount-- > 0) {
				rotateAntiClockwise();
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (arr[nr][nc] == 0 && !isCleaned[nr][nc]) {
					move(d);
					break;
				}
			}
		}
		
		private boolean move(int direction) {
			if (canMove(direction)) {
				r = r + dr[direction];
				c = c + dc[direction];
				return true;
			}
			return false;
		}
		
		private boolean canMove(int direction) {
			if (arr[r + dr[direction]][c + dc[direction]] == 0) {
				return true;
			}
			return false;
		}
		
		private boolean clean() {
			if (arr[r][c] == 1) return false;
			if (isCleaned[r][c]) return false;
			count++;
			return isCleaned[r][c] = true;
		}
		
		private boolean lookAround() {
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (arr[nr][nc] == 0 && !isCleaned[nr][nc]) return true;
			}
			return false;
		}
		
		private void rotateAntiClockwise() {
			d = (d + 3) % 4;
		}
		
		private int getBackwardIndex () {
			return (d + 2) % 4;
		}
	}
	
	public static void main (String[] args) throws IOException {
		int N = readInt();
		int M = readInt();
		int r = readInt();
		int c = readInt();
		int d = readInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = readInt();
			}
		}
		
		System.out.println(new Solution().solve(N, M, r, c, d, arr));
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

