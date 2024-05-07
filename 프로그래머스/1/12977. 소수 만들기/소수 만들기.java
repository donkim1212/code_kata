class Solution {
    public int solution(int[] nums) {
        int[] checked = new int[2998]; // max 2997
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    cur = nums[i] + nums[j] + nums[k];
                    if (checked[cur] == 0) checked[cur] = checkPrime(cur);
                    if (checked[cur] == -1) continue;
                    if (checked[cur] == 2) count++;
                }
            }
        }
        return count;
    }
    
    private int checkPrime (int num) {
        // double sqrt = Math.sqrt(num);
        // if (sqrt - Math.floor(sqrt) == 0) return -1;
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0) return -1;
        }
        return 2;
    }
}
