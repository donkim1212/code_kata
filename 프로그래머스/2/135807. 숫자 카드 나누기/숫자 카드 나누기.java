import java.lang.Math;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aGCD = getArrGCD(arrayA);
        int bGCD = getArrGCD(arrayB);
        boolean aDivB = checkDivisible(arrayB, aGCD);
        boolean bDivA = checkDivisible(arrayA, bGCD);
        if (aDivB && bDivA) return 0;
        if (aDivB && !bDivA) return bGCD;
        if (!aDivB && bDivA) return aGCD;
        return Math.max(aGCD, bGCD);
    }
    
    private boolean checkDivisible(int[] arr, int div) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % div == 0) return true;
        }
        return false;
    }
    
    private int getArrGCD (int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = getGCD(gcd, arr[i]);
        }
        return gcd;
    }
    
    private int getGCD (int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        while ((a % b) != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}