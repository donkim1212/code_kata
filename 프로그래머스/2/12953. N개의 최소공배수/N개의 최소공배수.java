class Solution {
    public int solution(int[] arr) {
        // LCM = a * b * ... * (n - 1)
        int ret = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ret = findLCM(arr[i], ret);
        }
        System.out.println(ret);
        return ret;
    }
    
    private int findLCM (int a, int b) {
        return a * b / ((a > b) ? findGCD(a, b) : findGCD(b, a));
    }
    
    private int findGCD (int a, int b) {
        while (b % a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return a;
    }
 }