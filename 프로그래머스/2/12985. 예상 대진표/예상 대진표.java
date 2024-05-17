class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        while ((a = getNextRoundNumber(a)) != (b = getNextRoundNumber(b))) {
            round++;
        }
        return round;
    }
    
    private int getNextRoundNumber(int player) {
        if (player == 1) return 1;
        else return player / 2 + player % 2;
    }
}