class Solution {
    public int[] solution(int[] numbers) {
        int[] initCounts = new int[101];
        boolean[] retCounts = new boolean[201];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (initCounts[numbers[i]]++ == 1 && !retCounts[numbers[i] * 2]) {
                retCounts[numbers[i] * 2] = true;
                count++;
                continue;
            }
            else if (initCounts[numbers[i]] == 1) {
                for (int j = i - 1; j >= 0; j--) {
                if (!retCounts[numbers[i] + numbers[j]]) {
                    retCounts[numbers[i] + numbers[j]] = true;
                    count++;
                }
            }
            }
        }
        int[] ret = new int[count];
        int ind = 0;
        for (int i = 0; i < retCounts.length; i++) {
            if (retCounts[i]) ret[ind++] = i;
        }
        
        return ret;
    }
}