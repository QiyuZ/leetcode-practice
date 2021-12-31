// class Leaderboard {
//     Map<Integer, Integer> map;
//     PriorityQueue<Map.Entry<Integer, Integer>> pq;
//     public Leaderboard() {
//         this.map = new HashMap<>();
//     }
    
//     public void addScore(int playerId, int score) {
//         map.put(playerId, map.getOrDefault(playerId, 0) + score);
//     }
    
//     public int top(int K) {
//         pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             pq.offer(entry);
//             if (pq.size() > K) pq.poll();
//         }
//         int sum = 0;
//         while (!pq.isEmpty()) sum += pq.poll().getValue();
//         return sum;
        
//     }
    
//     public void reset(int playerId) {
//         map.put(playerId, 0);
//     }
// }

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */

//another tradeoff way to use tree map
class Leaderboard {
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> sorted; //score - people amount
    public Leaderboard() {
        map = new HashMap<>();
        sorted = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!map.containsKey(playerId)) {
            map.put(playerId, score);
            sorted.put(score, sorted.getOrDefault(score, 0) + 1);
        } else {
            int preScore = map.get(playerId);
            sorted.put(preScore, sorted.get(preScore) - 1);
            if (sorted.get(preScore) == 0) {
                sorted.remove(preScore);
            }
            int newScore = preScore + score;
            map.put(playerId, newScore);
            sorted.put(newScore, sorted.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int count = 0;
        int sum = 0;
        for (int key : sorted.keySet()) {
            int times = sorted.get(key);
            for (int i = 0; i < times; i++) {
                sum += key;
                count++;
                if (count == K) {
                    break;
                }
            }
            if (count == K) {
                break;
            }
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int preScore = map.get(playerId);
        sorted.put(preScore, sorted.get(preScore) - 1);
        if (sorted.get(preScore) == 0) {
            sorted.remove(preScore);
        }
        map.remove(playerId);
    }
}
