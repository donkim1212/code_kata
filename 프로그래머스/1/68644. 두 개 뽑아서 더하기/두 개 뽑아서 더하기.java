class Solution {
    public int[] solution(int[] numbers) {
        boolean[] initCount = new boolean[101];
        boolean[] retCount = new boolean[201];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (initCount[numbers[i]] && !retCount[numbers[i] * 2]) {
                retCount[numbers[i] * 2] = true;
                count++;
                continue;
            }
            initCount[numbers[i]] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (!retCount[numbers[i] + numbers[j]]) {
                    retCount[numbers[i] + numbers[j]] = true;
                    count++;
                }
            }
        }
        int[] ret = new int[count];
        int ind = 0;
        for (int i = 0; i < retCount.length; i++) {
            if (retCount[i]) ret[ind++] = i;
        }
        
        return ret;
    }
}