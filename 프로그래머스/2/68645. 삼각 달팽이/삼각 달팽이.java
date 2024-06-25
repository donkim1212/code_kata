class Solution {
    private int[] lengths, answer;
    private boolean[] visited;
    private int n;
    public int[] solution(int n) {
        if (n == 1) return new int[] {1};
        this.n = n;
        lengths = new int[n + 1];
        setLengths(n);
        answer = new int[lengths[n]];
        visited = new boolean[lengths[n]];
        // try{
        fillBorder(1, 0, 0);
        // } catch(Exception e){
        //     // e.printStackTrace();
        // }
        return answer;
    }
    
    private void fillBorder (int startNum, int startWidth, int startHeight) {
        int num = startNum;
        int h = startHeight;
        int w = startWidth;
        
        // down left
        int index;
        while (h < lengths.length - 1 && !visited[index = w + lengths[h]]) {
            answer[index] = num++;
            visited[index] = true;
            h++;
        }
        h--;
        
        // right
        while ((index = ++w + lengths[h]) < lengths[h] + h + 1 && !visited[index]) {
            answer[index] = num++;
            visited[index] = true;
        }
        w--;
        
        // up
        while (!visited[(index = --w + lengths[--h])]) {
            answer[index] = num++;
            visited[index] = true;
        }
        w++;
        h += 2;
        
        if (h < lengths.length - 1 && !visited[w + lengths[h]]) {
            fillBorder(num, w, h);
        }
    }
    
    private void setLengths (int num) {
        for (int i = 1; i <= num; i++) {
            lengths[i] = lengths[i - 1] + i;
        }
    }
}