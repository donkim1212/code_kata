class Solution {
    private int[][] dungeons;
    private int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        
        for (int i = 0; i < dungeons.length; i++) {
            boolean[] visited = new boolean[dungeons.length];
            visited[i] = true;
            enterTheDungeon(k, 0, i, visited);
            visited[i] = false;
        }
        
        return max;
    }
    
    private void enterTheDungeon(int k, int depth, int dungeon, boolean[] visited) {
        if (k < dungeons[dungeon][0]){
            if (max < depth) max = depth;
            return;
        }
        k -= dungeons[dungeon][1];
        depth++;
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            enterTheDungeon(k, depth, i, visited);
            visited[i] = false;
        }
        
        
        if (max < depth) max = depth;
    }
}