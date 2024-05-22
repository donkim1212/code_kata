class Solution {
    public int solution(int[] priorities, int location) {
        int[] counts = new int[10]; // 1~9
        for (int i = 0; i < priorities.length; i++) {
            counts[priorities[i]]++;
        }
        
        int curPriority = 9;
        for (int i = 9; i >= 0; i--) { // find max priority
            if (counts[i] > 0) {
                curPriority = i;
                break;
            }
        }
        
        int cursor = 0;
        int ret = 0;
        
        while (true) {
            if (counts[curPriority] <= 0) curPriority--;
            if (priorities[cursor] != curPriority) {
                cursor = (cursor + 1) % priorities.length;
            }
            else { // if current priority, pop
                priorities[cursor] = -1;
                counts[curPriority]--;
                ret++;
                if (cursor == location) break;
            }
        }
        
        return ret;
    }
}