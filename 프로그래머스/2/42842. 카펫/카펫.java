import java.lang.Math;

class Solution {
    public int[] solution(int brown, int yellow) {
        // w * h = yellow, brown = 2w + 2h + 4
        int[] ret = new int[2];
        for (int h = 1; h <= yellow; h++) {
            if (yellow % h != 0) continue;
            int w = yellow / h;
            if (w * 2 + h * 2 + 4 == brown) {
                ret[0] = w + 2;
                ret[1] = h + 2;
                break;
            }
        }
        return ret;
    }
}