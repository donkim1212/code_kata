import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
	private static int N, M, x, y, K;
	private static int[][] map;
	private static int[] dice = new int[6];
	private static int top = 0;
	private static int up = 1;
	private static int right = 2;
	private static final int EYES_MAX_INDEX = 5;
	private static StringBuilder sb = new StringBuilder();
	public static void main (String[] args) throws IOException {
		N = readInt();
		M = readInt();
		x = readInt();
		y = readInt();
		K = readInt();
		map = new int[N][M];
		
		initMap();
		
		for (int i = 0; i < K; i++) {
			runCommand();
		}
		
		System.out.print(sb.toString());
	}
	
	private static void runCommand() throws IOException {
		int cmd = readInt();
		
		if (!checkCommandValidity(cmd)) return;
		
		move(cmd);
		rotateDice(cmd);
		
		if (map[x][y] == 0) {
			map[x][y] = dice[EYES_MAX_INDEX - top];
		}
		else {
			dice[EYES_MAX_INDEX - top] = map[x][y];
			map[x][y] = 0;
		}
		
		sb.append(dice[top]);
		sb.append('\n');
	}
	
	private static void move (int cmd) {
		if (cmd == 1) y++;
		else if (cmd == 2) y--;
		else if (cmd == 3) x--;
		else if (cmd == 4) x++;
	}
	
	private static void rotateDice(int cmd) {
		if (cmd == 1) {
			int newTop = EYES_MAX_INDEX - right;
			right = top;
			top = newTop;
		}
		else if (cmd == 2) {
			int newTop = right;
			right = EYES_MAX_INDEX - top;
			top = newTop;
		}
		else if (cmd == 3) {
			int newTop = EYES_MAX_INDEX - up;
			up = top;
			top = newTop;
		}
		else if (cmd == 4) {
			int newTop = up;
			up = EYES_MAX_INDEX - top;
			top = newTop;
		}
	}
	
	private static boolean checkCommandValidity(int cmd) {
		if (cmd == 1 && y >= M - 1) return false;
		if (cmd == 2 && y <= 0) return false;
		if (cmd == 3 && x <= 0) return false;
		if (cmd == 4 && x >= N - 1) return false;
		return true;
	}
	
	private static void initMap() throws IOException {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = readInt();
			}
		}
	}

	private static int readInt() throws IOException {
	    int c, ret = 0;
	    while ((c = System.in.read()) > 47) ret = 10 * ret + c - 48;
	    if (c == 13) System.in.read(); // for Windows
	    return ret;
	}
}
