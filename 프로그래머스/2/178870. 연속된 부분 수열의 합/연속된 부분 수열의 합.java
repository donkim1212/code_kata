import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = sequence.length - 1;
        int right = left;
        int sum = 0;
        while (left >= 0) {
            sum += sequence[left--];
            if (sum == k) {
                int tempSum = sum;
                int tempLeft = left;
                int tempRight = right;
                while (tempLeft >= 0) {
                    tempSum += sequence[tempLeft];
                    tempSum -= sequence[tempRight];
                    if (sum != tempSum) {
                        return new int[] {tempLeft + 1, tempRight};
                    }
                    tempLeft--;
                    tempRight--;
                }
                left = tempLeft;
                right = tempRight;
                break;
            }
            if (sum > k) sum -= sequence[right--];
        }
        return new int[] {left + 1, right};
    }
}