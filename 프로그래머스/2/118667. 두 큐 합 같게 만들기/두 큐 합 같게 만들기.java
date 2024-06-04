class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        boolean sw1 = false;
        boolean sw2 = false;
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                if (!sw1) {
                    sum1 -= queue1[p1];
                    sum2 += queue1[p1++];
                }
                else {
                    sum1 -= queue2[p1];
                    sum2 += queue2[p1++];
                }
                if (p1 >= queue1.length) {
                    if (sw1) break;
                    p1 = 0;
                    sw1 = true;
                }
                count++;
            }
            else if (sum1 < sum2) {
                if (!sw2) {
                    sum2 -= queue2[p2];
                    sum1 += queue2[p2++];
                }
                else {
                    sum2 -= queue1[p2];
                    sum1 += queue1[p2++];
                }
                if (p2 >= queue1.length) {
                    if (sw2) break;
                    p2 = 0;
                    sw2 = true;
                }
                count++;
            }
        }
        
        if (sum1 == sum2) return count;
        return -1;
        
    }
}