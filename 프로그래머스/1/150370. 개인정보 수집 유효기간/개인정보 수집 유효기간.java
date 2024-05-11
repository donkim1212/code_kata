class Solution {
    private final int DAYS_PER_MONTH = 28;
    private final int DAYS_PER_YEAR = 336; // 28 * 12
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // ASCII
        // 'A' = 65, 'Z' = 90
        int[] expiry = getExpiryArr(terms);
        boolean[] expired = new boolean[privacies.length + 1];
        int todayInDays = stringToDays (today);
        int expiredCount = 0;
        
        // find index & count of expired privacies
        for (int i = 0; i < privacies.length; i++) {
            int daysPassed = todayInDays - stringToDays(privacies[i]);
            // privacies[i]:
            // YYYY.MM.DD [A-Z]
            if (daysPassed >= expiry[privacies[i].charAt(11)]) {
                expired[i + 1] = true;
                expiredCount++;
            }
        }
        
        // create expired array to return
        int idx = 0;
        int[] ret = new int[expiredCount];
        for (int i = 0; i < expired.length; i++) {
            if (expired[i]) ret[idx++] = i;
        }
        return ret;
    }
    
    private int stringToDays (String date) {
        // YYYY.MM.DD
        return parseInt(date, 8, 10)
            + parseInt(date, 5, 7) * DAYS_PER_MONTH
            + parseInt(date, 0, 4) * DAYS_PER_YEAR;
    }
    
    private int[] getExpiryArr (String[] terms) {
        int[] expiry = new int[91];
        for (int i = 0; i < terms.length; i++) {
            String cur = terms[i];
            expiry[cur.charAt(0)] = parseInt(cur, 2, cur.length()) * DAYS_PER_MONTH;
        }
        return expiry;
    }
    
    private int parseInt (String str, int start, int end) {
        int ret = 0;
        for (int i = start; i < Math.min(str.length(), end); i++) {
            ret = ret * 10 + str.charAt(i) - 48;
        }
        return ret;
    }
}