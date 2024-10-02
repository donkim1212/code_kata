using System.Numerics;

namespace Solution
{
    public class B11401
    {
        private const int DIV = 1000000007; // 10억 + 7 (소수)
        public static void Main(string[] args)
        {
            int N = ReadInt();
            int K = ReadInt();
            long dFac = Factorial(N - K, 1, 1); // (N-K)!
            long kFac = Factorial(K, N - K, dFac); // K!
            long nFac = Factorial(N, K, kFac); // N!
            
            // N! / (K! * (N-K)!) % DIV == (N! * (K!)^(-1) % DIV * ((N-K)!)^(-1) % DIV) % DIV
            long bCoef = nFac * ModInverse(kFac, DIV) % DIV * ModInverse(dFac, DIV) % DIV;
            Console.WriteLine("{0}", bCoef);
        }
        
        private static long Factorial(int end, int start, long cur)
        {
            long dp = cur;
            for(int i = start + 1; i <= end; i++)
            {
                dp = (dp * i) % DIV;
            }
            return dp;
        }
        
        private static long ModInverse(long n, int mod)
        {
            return (long) BigInteger.ModPow(n, mod - 2, mod);
        }
        
        private static int ReadInt()
        {
            int c, ret = 0;
            while ((c = Console.Read()) > 47)
            {
                ret = ret * 10 + c - 48;
            }
            if (c == 13) Console.Read();
            return ret;
        }
    }
}