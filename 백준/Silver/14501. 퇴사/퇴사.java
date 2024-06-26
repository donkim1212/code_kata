import java.io.IOException;

public class Main {
    private static int N, max, c, val = 0;
    private static int[] T, P;
    public static void main(String[] args) throws IOException {
        readInt();
        N = val;
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            readInt();
            T[i] = val;
            readInt();
            P[i] = val;
        }
        findMaxPayment(0, 0);
        System.out.println(max);
    }
    
    private static void findMaxPayment(int index, int sum) {
        if (index >= N) {
            if (max < sum) max = sum;
            return;
        }
        if (T[index] == 1) {
            findMaxPayment(index + T[index], sum + P[index]);
        }
        if (T[index] > 1) {
            findMaxPayment(index + 1, sum); // skip today's appointment
            if (index + T[index] <= N) {
                findMaxPayment(index + T[index], sum + P[index]);
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