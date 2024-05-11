import java.lang.StringBuilder;
class Solution {
    public String solution(String[] survey, int[] choices) {
        // possible contents of survey:
        // "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
        // ASCII
        // 'A' = 65, 'Z' = 90
        StringBuilder sb = new StringBuilder();
        int[] points = new int[91];
        
        for (int i = 0; i < survey.length; i++) {
            int curChoice = choices[i];
            if (curChoice == 4) continue;
            if (curChoice > 4) points[survey[i].charAt(1)] += curChoice - 4;
            else points[survey[i].charAt(0)] += 4 - curChoice;
        }
        
        sb.append ((points['R'] >= points['T']) ? "R" : "T");
        sb.append ((points['C'] >= points['F']) ? "C" : "F");
        sb.append ((points['J'] >= points['M']) ? "J" : "M");
        sb.append ((points['A'] >= points['N']) ? "A" : "N");
        return sb.toString();
    }
}