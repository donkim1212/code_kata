class Solution {
    public int solution(String[] babbling) {
        String[] words = new String[] {"aya", "ye", "woo", "ma"};
        int count = 0;
        int prev = 0;
        for (int i = 0; i < babbling.length; i++) {
            prev = 0;
            int length = babbling[i].length();
            if (length == 1) continue;
            boolean babblable = true;
            int idx = 0;
            while (idx < length) {
                if (length <= idx + 1) {
                    babblable = false;
                    break;
                }
                char cur = babbling[i].charAt(idx);
                char next = babbling[i].charAt(idx + 1);
                if (cur == 'y' && next == 'e') {
                    if (prev == 1) {
                        babblable = false;
                        break;
                    }
                    prev = 1;
                    idx += 2;
                    continue;
                }
                if (cur == 'm' && next == 'a') {
                    if (prev == 2) {
                        babblable = false;
                        break;
                    }
                    prev = 2;
                    idx += 2;
                    continue;
                }
                if (length <= idx + 2) {
                    babblable = false;
                    break;
                }
                char nextnext = babbling[i].charAt(idx + 2);
                if (cur == 'a' && next == 'y' && nextnext == 'a') {
                    if (prev == 3) {
                        babblable = false;
                        break;
                    }
                    prev = 3;
                    idx += 3;
                    continue;
                }
                if (cur == 'w' && next == 'o' && nextnext == 'o') {
                    if (prev == 4) {
                        babblable = false;
                        break;
                    }
                    prev = 4;
                    idx += 3;
                    continue;
                }
                babblable = false;
                break;
            }
            if (babblable) count++;
        }
        return count;
    }
}