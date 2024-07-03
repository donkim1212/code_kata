import java.util.Stack;
import java.util.HashMap;

class Solution {
    private HashMap<Integer, Stack<Integer>> hm = new HashMap<Integer, Stack<Integer>>();
    private int[][] result;
    private int index = 0;
    public int[][] solution(int n) {
        hm.put(1, new Stack<Integer>());
        hm.put(2, new Stack<Integer>());
        hm.put(3, new Stack<Integer>());
        result = new int[getResultSize(n)][2];
        
        init(n, 1);
        move(n, 1, 2, 3);
        
        return result;
    }
    
    private void move (int n, int originIndex, int midIndex, int destIndex) {
        if (n == 1) {
            hm.get(destIndex).push(hm.get(originIndex).pop());
            result[index++] = new int[] { originIndex, destIndex };
            return;
        }
        else {
            move (n - 1, originIndex, destIndex, midIndex);
            move (1, originIndex, midIndex, destIndex);
            move (n - 1, midIndex, originIndex, destIndex);
        }
        
    }
    
    private int getResultSize (int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret * 2 + 1;
        }
        return ret;
    }
    
    private void init(int n, int stackNumber) {
        Stack<Integer> target = hm.get(stackNumber);
        for (int i = n; i >= 1; i--) {
            target.push(i);
        }
    }
}