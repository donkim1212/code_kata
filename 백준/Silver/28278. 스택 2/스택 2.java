import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] stack = new int[N + 1];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int command = readInt();
            if (command == 1) {
                int x = readInt();
                stack[index++] = x;
                count++;
            }
            else if (command == 2) {
                if (index > 0) {
                    sb.append(stack[--index]);
                    count--;
                }
                else sb.append(-1);
                sb.append('\n');
            }
            else if (command == 3) {
                sb.append(count);
                sb.append('\n');
            }
            else if (command == 4) {
                sb.append(count == 0 ? 1 : 0);
                sb.append('\n');
            }
            else if (command == 5) {
                if (index > 0) {
                    sb.append(stack[index - 1]);
                }
                else {
                    sb.append(-1);
                }
                sb.append('\n');
            }
        }
        
        System.out.print(sb.toString());
    }
    
    private static int readInt() throws IOException {
		int c, ret = 0;
		while ((c = System.in.read()) > 47) ret = 10 * ret + c - 48;
		if (c == 13) System.in.read(); // for Windows
		return ret;
	}
}