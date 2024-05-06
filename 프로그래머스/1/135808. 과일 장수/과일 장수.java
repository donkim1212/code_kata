class Solution {
    public int solution(int k, int m, int[] score) {
        if (m > score.length) return 0;
        int[] counts = new int[k + 1];
        for (int i = 0; i < score.length; i++) {
            counts[score[i]]++;
        }
        int total = 0;
        int prev = 0;
        for (int i = counts.length - 1; i >= 1; i--) {
            int boxes = (int) Math.floor(counts[i] / m);
            int leftover = (counts[i] % m) + prev;
            total += boxes * i * m + ((int) Math.floor(leftover / m) * i * m);
            prev = leftover % m;
        }
        return total;
    }
}