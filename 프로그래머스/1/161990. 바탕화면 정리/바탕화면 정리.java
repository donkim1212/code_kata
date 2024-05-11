class Solution {
    private final char FILE_CHAR = '#';
    public int[] solution(String[] wallpaper) {
        int[] ret = initCoords(wallpaper);
        for (int i = ret[0]; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            int index = row.indexOf(FILE_CHAR);
            if (index != -1) {
                ret[1] = Math.min(ret[1], index);
                ret[2] = i + 1;
                index = row.lastIndexOf(FILE_CHAR);
                ret[3] = Math.max(ret[3], index + 1);
            }
        }
        return ret;
    }
    
    private int[] initCoords (String[] wp) {
        int idx = 0;
        int cur = -1;
        do {
            cur = wp[idx].indexOf(FILE_CHAR);
            if (cur != -1) break;
        } while (++idx < wp.length);
        return new int[] {idx, cur, idx + 1, cur + 1};
    }
}