import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int prev = completesIn(progresses[0], speeds[0]);
        int count = 1;
        
        for (int i = 1; i < progresses.length; i++) {
            int cur = completesIn(progresses[i], speeds[i]);
            if (prev >= cur) count++;
            else {
                list.add(count);
                prev = cur;
                count = 1;
            }
        }
        
        list.add(count);
        
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
    
    private int completesIn(int progress, int speed) {
        // (100 - progress) / speed (+1 if mod != 0)
        int left = 100 - progress;
        return left / speed + (left % speed != 0 ? 1 : 0);
    }
}