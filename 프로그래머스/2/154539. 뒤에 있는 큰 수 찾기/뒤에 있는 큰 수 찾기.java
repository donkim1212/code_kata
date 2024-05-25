class Solution {
    public int[] solution(int[] numbers) {
        int max = 0;
        int[] ret = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] >= max) {
                max = numbers[i];
                ret[i] = -1;
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    ret[i] = numbers[j];
                    break;
                }
                else if (ret[j] > numbers[i]) {
                    ret[i] = ret[j];
                    break;
                }
            }
        }
        return ret;
    }
}