class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] contains = new boolean[46];
        int[] ranks = new int[] {6, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < 6; i++) {
            contains[win_nums[i]] = true;
        }
        int zeroes = 0;
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) zeroes++;
            else if (contains[lottos[i]]) matches++;
        }
        return new int[] {ranks[matches + zeroes], ranks[matches]};
    }
}