using System;

namespace baekjoon
{
    internal class Program
    {
        static void Main(string[] args)
        {
        	long.TryParse(Console.ReadLine(), out long input);
            int count = 0;
            long sum = 0;
            long num = 1;
            while (input > sum) {
                sum += num++;
                if (sum > input) break;
                count++;
            }
            Console.WriteLine(count);
        }
    }
}