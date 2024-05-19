class Solution {
    public int solution(int[] citations) {
        int[] h = new int[10001];
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            h[citations[i]]++;
            if (max < citations[i]) max = citations[i];
        }
        
        int sum = 0;
        for (int i = max; i >= 0; i--) {
            sum += h[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}