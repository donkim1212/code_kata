class Solution {
    private boolean[] check = new boolean[500001];
    public int solution(int[] elements) {
        int i = 0;
        do {
            int j = i++;
            int length = 1;
            int sum = 0;
            while (length++ <= elements.length) {
                sum += elements[j++];
                check[sum] = true;
                if (j >= elements.length) j = 0;
            }
        } while (i < elements.length);
        
        int count = 0;
        for (int n = 0; n < check.length; n++) {
            if (check[n]) count++;
        }
        
        return count;
    }
}