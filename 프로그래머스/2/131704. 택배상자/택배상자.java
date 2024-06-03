import java.util.Stack;

class Solution {
    private Stack<Integer> stack = new Stack<Integer>();
    public int solution(int[] order) {
        int count = 0;
        int k = 0;
        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            while (!stack.empty()) {
                if (stack.peek() == order[k]) {
                    stack.pop();
                    k++;
                    count++;
                }
                else break;
            }
        }
        return count;
    }
}