class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j ++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) score[j]++;
            }
        }
        int max = score[0];
        int count = 1;
        int idx = 0;
        for (int i = 1; i < score.length; i++) {
            if (score[i] > max) {
                idx = i;
                max = score[i];
                count = 1;
            }
            else if (score[i] == max) {
                idx += i;
                count++;
            }
        }
        
        if (count == 3) return new int[] {1, 2, 3};
        if (count == 1) return new int[] {idx + 1};
        if (idx == 3) return new int[] {2, 3};
        return new int[] {1, idx + 1};
    }
}