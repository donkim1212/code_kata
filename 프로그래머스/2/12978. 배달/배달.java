import java.util.PriorityQueue;
import java.util.ArrayList;

class Solution {
    private class Node implements Comparable<Node> {
        private int cur, time;
        public Node (int cur, int time) {
            this.cur = cur;
            this.time = time;
        }
    
        public int getCur () {
            return cur;
        }
    
        public int getTime () {
            return time;
        }
        
        @Override
        public int compareTo (Node other) {
            return this.time - other.time;
        }
    }
    private PriorityQueue<Node> pq = new PriorityQueue<Node>();
    private ArrayList<ArrayList<Node>> lines = new ArrayList<ArrayList<Node>>();
    public int solution(int N, int[][] road, int K) {
        int length = N + 1;
        initLines(N + 1, road);
        boolean[] visited = new boolean[length];
        
        int ret = 0;
        pq.add(new Node(1, 0));
        int dest, time;
        while (pq.peek() != null) {
            Node node = pq.poll();
            if (node.getTime() > K) break;
            if (visited[node.getCur()]) continue;
            visited[node.getCur()] = true;
            ret++;
            for (int i = 0; i < lines.get(node.getCur()).size(); i++) {
                dest = lines.get(node.getCur()).get(i).getCur();
                if (visited[dest]) continue;
                time = node.getTime() + lines.get(node.getCur()).get(i).getTime();
                pq.add(new Node(dest, time));
            }
        }
        
        return ret;
    }
    
    private void initLines(int N, int[][] road) {
        for (int i = 0; i < N; i++) {
            lines.add(new ArrayList<Node>());
        }
        for (int i = 0; i < road.length; i++) {
            lines.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            lines.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
    }
}