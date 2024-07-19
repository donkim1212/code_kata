import java.io.IOException;
import java.lang.StringBuilder;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
	public static void main (String[] args) throws IOException {
		int N = readInt();
		int M = readInt();
		
		HashSet<String> neverHeardOf = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			neverHeardOf.add(readString());
		}
		TreeSet<String> dbj = new TreeSet<String>();
		
		for (int i = 0; i < M; i++) {
			String neverSeen = readString();
			if (neverHeardOf.contains(neverSeen)) {
				dbj.add(neverSeen);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dbj.size()).append('\n');
		while (!dbj.isEmpty()) {
			sb.append(dbj.pollFirst()).append('\n');
		}
		
		System.out.print(sb.toString());
	}
	
	private static String readString() throws IOException {
		int c = 0;
		StringBuilder ret = new StringBuilder();
		while ((c = System.in.read()) > 96) {
			ret.append((char) c);
		}
		if (c == 13) System.in.read();
		return ret.toString();
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
