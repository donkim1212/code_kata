class Solution {
    private int[] numbers;
    private int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        int answer = 0;
        answer = dfs(0, 0);
        return answer;
    }
    
    private int dfs (int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }
        return dfs(index + 1, sum + numbers[index])
            + dfs (index + 1, sum - numbers[index]);
    }
}