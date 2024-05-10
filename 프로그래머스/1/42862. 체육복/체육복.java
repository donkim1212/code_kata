class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] current = new int[n + 2]; // include 0 and n + 1 to prevent IOB
        for (int i : lost) current[i]--;
        for (int i : reserve) current[i] ++;
        for (int i = 1; i < current.length - 1; i++) {
            if (current[i] < 0) { // if lost
                if (current[i - 1] > 0) current[i - 1]--; // borrow from front
                else if (current[i + 1] > 0) current[i + 1]--; // from back
                else n--; // can't attend
            }
        }
        return n;
    }
}