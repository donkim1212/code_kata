import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
	public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
		int T = readInt();
        for (int i = 0; i < T; i++) {
            int cents = readInt();
            int quarters = cents / 25;
            sb.append (quarters);
            sb.append (" ");
            cents = cents % 25;
            int dimes = cents / 10;
            sb.append (dimes);
            sb.append (" ");
            cents = cents % 10;
            int nickels = cents / 5;
            sb.append (nickels);
            sb.append (" ");
            sb.append (cents % 5);
            sb.append ("\n");
        }
		System.out.println(sb.toString());
	}
    
    private static int readInt() throws IOException {
        int c, ret = 0;
        while ((c = System.in.read()) > 13){
            ret = 10 * ret + c - 48;
        }
        return ret;
    }
}
