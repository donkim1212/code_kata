import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
	private static int[] nums, ops;
	private static int N;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		N = readInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = readInt();
		}
		ops = new int[4];
		for (int i = 0; i < 4; i++) {
			ops[i] = readInt();
		}
		findMinMax(nums[0], 1);
		sb.append(max);
		sb.append('\n');
		sb.append(min);
		System.out.print(sb.toString());
	}
	
	private static void findMinMax(int acc, int index) {
		if (index >= N) {
			if (max < acc) max = acc;
			if (min > acc) min = acc;
			return;
		}
		if (ops[0] > 0) {
			ops[0]--;
			findMinMax(acc + nums[index], index + 1);
			ops[0]++;
		}
		if (ops[1] > 0) {
			ops[1]--;
			findMinMax(acc - nums[index], index + 1);
			ops[1]++;
		}
		if (ops[2] > 0) {
			ops[2]--;
			findMinMax(acc * nums[index], index + 1);
			ops[2]++;
		}
		if (ops[3] > 0) {
			ops[3]--;
			findMinMax(acc / nums[index], index + 1);
			ops[3]++;
		}
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