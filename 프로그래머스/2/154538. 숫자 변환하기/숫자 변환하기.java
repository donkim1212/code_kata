import java.util.LinkedList;

class Solution {
    private class Node {
        private int number, count;
        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
        
        public int getNumber() {
            return this.number;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
    private LinkedList<Node> queue = new LinkedList<Node>();
    
    public int solution(int x, int y, int n) {
        queue.add(new Node(y, 0));
        while(!queue.isEmpty()) {
            Node cur = queue.pop();
            if (cur.getNumber() == x) return cur.getCount();
            int newCount = cur.getCount() + 1;
            int numA = cur.getNumber() - n;
            if (numA >= x) queue.add(new Node(numA, newCount));
            int numB;
            if (cur.getNumber() % 2 == 0 && (numB = cur.getNumber() / 2) >= x) {
                queue.add(new Node(numB, newCount));
            }
            int numC;
            if (cur.getNumber() % 3 == 0 && (numC = cur.getNumber() / 3) >= x) {
                queue.add(new Node(numC, newCount));
            }
        }
        
        return -1;
    }
}