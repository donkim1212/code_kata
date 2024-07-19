import java.io.IOException;

public class Main {
    private static class Solution {
        public void solve(int total, int start, int dest, int up, int down) {
        	boolean[] visited = new boolean[total + 1];
        	int count = 0;
        	
            while (start != dest) {
                if (visited[start]) break;
                visited[start] = true;
                count++;
                
                if ((start < dest || start - down < 1) && start + up <= total) start += up;
                else if ((start > dest || start + up > total) && start - down > 0) start -= down;
            }
            if (start == dest) {
            	System.out.print(count);
            	return;
            }
            System.out.print("use the stairs");
        }
    }
    public static void main (String[] args) throws IOException {
        new Solution().solve(readInt(), readInt(), readInt(), readInt(), readInt());
    }
    
    private static int readInt() throws IOException {
        int c, ret = 0;
        while ((c = System.in.read()) > 47) {
            ret = (ret << 3) + (ret << 1) + (c & 0xF);
        }
        if (c == 13) System.in.read();
        return ret;
    }
}