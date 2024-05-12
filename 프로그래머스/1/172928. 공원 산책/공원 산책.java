class Solution {
    private String[] park;
    private String[] routes;
    private int yMax;
    private int xMax;
    public int[] solution(String[] park, String[] routes) {
        this.park = park;
        this.routes = routes;
        yMax = park.length - 1;
        xMax = park[0].length() - 1;
        
        int[] curPos = initCurPos();
        
        return getFinalPos(curPos);
    }
    
    private int[] getFinalPos (int[] curPos) {
        for (int i = 0; i < routes.length; i++) {
            char direction = routes[i].charAt(0);
            int distance = parseInt(routes[i]);
            int isHorizontal = (direction == 'E' || direction == 'W') ? 1 : 0;
            if (direction == 'N' || direction == 'W') distance *= -1;
            if (canMove(curPos, isHorizontal, distance)) curPos[isHorizontal] += distance;
        }
        return curPos;
    }
    
    private boolean canMove (int[] curPos, int isHorizontal, int distance) {
        int limit = (distance < 0) ? 0 : (isHorizontal == 1) ? xMax : yMax;
        int next = curPos[isHorizontal] + distance;
        boolean immovable = (limit == 0) ? next < limit : next > limit;
        if (immovable) return false;
        int min = Math.min(curPos[isHorizontal], next);
        int max = Math.max(curPos[isHorizontal], next);
        if (isHorizontal == 0) {
            for (int i = min; i <= max; i++) {
                if (park[i].charAt(curPos[1]) == 'X') return false;
            }
        }
        else {
            for (int i = min; i <= max; i++) {
                if (park[curPos[0]].charAt(i) == 'X') return false;
            }
        }
        return true;
    }
    
    private int[] initCurPos () {
        for (int i = 0; i < park.length; i++) {
            int curX = park[i].indexOf('S');
            if (curX != -1) return new int[] {i, curX};
        }
        return new int[2];
    }
    
    private int parseInt(String s) {
        // ASCII
        // '0' = 48, '9' = 57
        return (int) s.charAt(2) - 48;
    }
}