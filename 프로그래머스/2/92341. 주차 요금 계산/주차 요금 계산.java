import java.util.HashMap;
import java.lang.Math;

class Solution {
    private HashMap<Integer, Integer> parked = new HashMap<>();
    private HashMap<Integer, Integer> parkedFor = new HashMap<>();
    private boolean[] hasParked = new boolean[10000]; // 0000~9999
    private int[] owes = new int[10000];
    private String[] records;
    private int[] fees;
    
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        this.records = records;
        
        int[] ret = new int[setFeesOwned()];
        int idx = 0;
        for (int i = 0; i < 10000; i++) {
            if (hasParked[i]) ret[idx++] = owes[i];
        }
        
        return ret;
    }
    
    /**
    * @returns number of cars visited
    */
    private int setFeesOwned () {
        int count = 0;
        
        for (int i = 0; i < records.length; i++) {
            int curMinutes = parseInt(records[i], 0, 2) * 60;
            curMinutes += parseInt(records[i], 3, 5);
            int carNumber = parseInt(records[i], 6, 10);
            if (records[i].charAt(11) == 'I') {
                if (!hasParked[carNumber]) count++;
                hasParked[carNumber] = true;
                parked.put(carNumber, curMinutes);
            }
            else {
                curMinutes -= parked.remove(carNumber);
                parkedFor.put(carNumber, parkedFor.getOrDefault(carNumber, 0) + curMinutes);
            }
        }
        
        int midnight = 1439; // 23 * 60 + 59
        for (Integer carNumber : parked.keySet()) {
            parkedFor.put(carNumber, parkedFor.getOrDefault(carNumber, 0) + midnight - parked.get(carNumber));
        }
        
        for (Integer carNumber : parkedFor.keySet()) {
            owes[carNumber] += calcFee(parkedFor.get(carNumber));
        }
        
        return count;
    }
    
    private int calcFee (int minutes) {
        int ret = fees[1];
        if ((minutes -= fees[0]) <= 0) return ret;
        ret += minutes / fees[2] * fees[3];
        if (minutes % fees[2] != 0) ret += fees[3];
        return ret;
    }
    
    private int parseInt(String s, int startIdx, int endIdx) {
        // ASCII '0' = 48
        int ret = 0;
        while (startIdx < endIdx) {
            char c = s.charAt(startIdx++);
            if (c < 48 || c > 57) break;
            ret = ret * 10 + c - 48;
        }
        
        return ret;
    }
}