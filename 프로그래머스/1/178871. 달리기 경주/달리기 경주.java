import java.util.HashMap;

class Solution {
    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    private String[] ranking;
    public String[] solution(String[] players, String[] callings) {
        ranking = new String[players.length];
        initRanking(players);
        
        getFinalRanking(callings);
        
        return ranking;
    }
    
    private void getFinalRanking(String[] callings) {
        for (int i = 0; i < callings.length; i++) {
            overtake(callings[i]);
        }
    }
    
    private void initRanking(String[] players) {
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            ranking[i] = players[i];
        }
    }
    
    private void overtake(String player) {
        int index = map.get(player);
        String temp = ranking[index];
        ranking[index] = ranking[index - 1];
        ranking[index - 1] = temp;
        map.put(player, index - 1);
        map.put(ranking[index], index);
    }
}