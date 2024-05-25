class Solution {
    private int[][] dungeons;
    private int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        boolean[] visited = new boolean[dungeons.length];
        enterTheDungeon(k, 0, visited);
        return max;
    }
    
    private void enterTheDungeon(int k, int depth, boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]){
                if (max < depth) max = depth;
                continue;
            }
            visited[i] = true;
            enterTheDungeon(k - dungeons[i][1], depth + 1, visited);
            visited[i] = false;
        }
        
        if (max < depth) max = depth;
    }
}