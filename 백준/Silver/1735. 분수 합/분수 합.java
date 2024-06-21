import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
    public static void main (String[] args) {
        try {
            int a1 = readInt();
            int b1 = readInt();
            int a2 = readInt();
            int b2 = readInt();
            int denominator = b1 * b2;
            int numerator = a1 * b2 + a2 * b1;
            
            int gcd = getGCD(denominator, numerator);
            
            numerator /= gcd;
            denominator /= gcd;
            StringBuilder sb = new StringBuilder();
            sb.append(numerator).append(" ").append(denominator);
            
            System.out.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static int getGCD (int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static int readInt() throws IOException {
        int c, ret = 0;
        while ((c = System.in.read()) > 47) {
            ret = ret * 10 + c - 48;
        }
        if (c == 13) System.in.read();
        return ret;
    }
}