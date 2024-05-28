class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] passesAt = new int[truck_weights.length];
        int passingIdx = 0;
        int onBridgeWeight = 0;
        int time = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            time++;
            int curWeight = truck_weights[i];
            if (onBridgeWeight + curWeight > weight) {
                while (passingIdx < i) {
                    onBridgeWeight -= truck_weights[passingIdx++];
                    if (onBridgeWeight + curWeight <= weight) break;
                }
                int passedAt = passesAt[passingIdx - 1];
                if (passedAt > time) time = passedAt;
            }
            passesAt[i] = time + bridge_length;
            onBridgeWeight += curWeight;
        }
        return passesAt[passesAt.length - 1];
    }
}