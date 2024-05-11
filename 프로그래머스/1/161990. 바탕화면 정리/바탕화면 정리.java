class Solution {
    public int[] solution(String[] wallpaper) {
        int[] ret = new int[] {50, 50, 0, 0};
        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            boolean found = false;
            for (int j = 0; j < row.length(); j++) {
                char cur = row.charAt(j);
                if (cur == '#') {
                    found = true;
                    ret[1] = Math.min(ret[1], j);
                    ret[3] = Math.max(ret[3], j + 1);
                }
            }
            if (found) {
                if (ret[0] == 50) ret[0] = i;
                ret[2] = i + 1;
            }
        }
        return ret;
    }
}