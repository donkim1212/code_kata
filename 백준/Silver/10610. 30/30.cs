using System;

namespace Solution
{
    public class Program
    {
        public static void Main(String[] args)
        {
            char[] charArr = Console.ReadLine().ToArray();
            if (!charArr.Contains('0'))
            {
                Console.WriteLine("-1");
                return;
            }
            int sum = 0;
            for (int i = 0; i < charArr.Length; i++)
            {
                sum += charArr[i];
            }
            if (sum % 3 != 0) {
                Console.WriteLine("-1");
                return;
            }
            Array.Sort(charArr);
            Array.Reverse(charArr);
            Console.WriteLine(charArr);
        }
    }
}