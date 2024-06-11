class Solution {
    public int solution(String[][] book_time) {
        int[] rooms  = new int[24 * 60 + 10];
        int max = 0;
        for(int i = 0; i < book_time.length; i++) {
            int inTime = convertToInt(book_time[i][0]);
            int outTime = convertToInt(book_time[i][1]) + 10;
            rooms[inTime]++;
            rooms[outTime]--;
        }
        
        for (int i = 1; i < rooms.length; i++) {
            rooms[i] += rooms[i - 1];
            if (rooms[i] > max) max = rooms[i];
        }
        
        return max;
    }
    
    private int convertToInt(String time) {
        int ret = 0;
        int temp = 0;
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c == ':') {
                ret = temp * 60;
                temp = 0;
            }
            else temp = temp * 10 + c - '0';
        }
        return ret + temp;
    }
}