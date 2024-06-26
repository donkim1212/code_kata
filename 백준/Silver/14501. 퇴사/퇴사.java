import java.io.IOException;
import java.lang.Math;

public class Main {
	private static int N, c, val = 0;
    private static int[] T, P, dp;
    public static void main(String[] args) throws IOException {
        readInt();
        N = val;
        T = new int[N];
        P = new int[N];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            readInt();
            T[i] = val;
            readInt();
            P[i] = val;
        }
        findMaxPayment();
        System.out.println(Math.max(dp[N], dp[N - 1]));
    }
    
    private static void findMaxPayment() {
    	if (T[0] <= N) {
    		dp[T[0]] = Math.max(dp[T[0]], P[0]);
    	}
        for (int i = 1; i < N; i++) {
        	dp[i] = Math.max(dp[i], dp[i - 1]);
        	if (i + T[i] <= N) {
        		dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
        	}
        }
    }
    
    private static void readInt() throws IOException {
    	val = 0;
        while ((c = System.in.read()) > 47) {
            val = 10 * val + c - 48;
        }
        if (c == 13) System.in.read();
    }
}