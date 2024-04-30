class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] arr : sizes) {
            int curMax = Math.max(arr[0], arr[1]);
            int curMin = Math.min(arr[0], arr[1]);
            if (curMax > w) w = curMax;
            if (curMin > h) h = curMin;
        }
        return w * h;
    }
}