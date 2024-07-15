import java.io.IOException;

public class Main {
	private static class Solution {
		public int solve(int a, int b) {
			int count = 1;
			while (b > a) {
				if ((b & 1) == 0) {
					b /= 2;
					count++;
					continue;
				}
				if (b % 10 != 1) {
					return -1;
				}
				b /= 10;
				count++;
			}
			if (b != a) return -1;
			return count;
		}
	}
	
	public static void main (String[] args) throws IOException {
		System.out.print(new Solution().solve(readInt(), readInt()));
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
