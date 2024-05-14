import java.util.HashMap;

class Solution {
    private HashMap<String, int[]> reported = new HashMap<String, int[]>();
    private HashMap<String, Integer> nameIndices = new HashMap<String, Integer>();
    private int length, k;
    public int[] solution(String[] id_list, String[] reports, int k) {
        this.length = id_list.length;
        this.k = k;
        
        setNameIndices(id_list);
        inspectReports(reports);
        return getMailsSentCount(id_list); 
    }
    
    // get how many mails sent per ids in id_list
    private int[] getMailsSentCount (String[] id_list) {
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            String user = id_list[i];
            int[] reporters = reported.get(user);
            if (reporters == null) continue;
            if (reporters[length] >= k) {
                for (int j = 0; j < length; j++) {
                    if (reporters[j] > 0) ret[j]++;
                }
            }
        }
        return ret;
    }
    
    // inspect reports and fill in 'reported' map
    private void inspectReports (String[] reports) {
        for (int i = 0; i < reports.length; i++) {
            String[] report = reports[i].split(" "); // [0] reporter, [1] reportee
            if (!reported.containsKey(report[1])) {
                // int[] reporters = ;
                reported.put(report[1], new int[length + 1]); // [length] == total reports
            }

            int[] reporters = reported.get(report[1]);
            int reporter = nameIndices.get(report[0]);
            if (reporters[reporter] > 0) continue;
            reporters[reporter] = reporters[reporter] + 1; // user index in id_list
            reporters[length] = reporters[length] + 1;
        }
    }
    
    // set name indices to 'nameIndices' map
    private void setNameIndices (String[] id_list) {
        for (int i = 0; i < length; i++) {
            nameIndices.put(id_list[i], i);
        }
    }
}