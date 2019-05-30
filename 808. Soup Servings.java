class Solution {
    public double soupServings(int N) {
        Map<Integer, Map<Integer, Double>> memo = new HashMap<>();
        return N > 5000 ? 1.0 : search(N, N, memo); //过大约等于1
    }
    
    private double search(int a, int b, Map<Integer, Map<Integer, Double>> memo) {
        if (a <= 0 && b <= 0) return 0.5; //只能是同时 1.0 / 2
        if (a <= 0) return 1.0; //a先用完
        if (b <= 0) return 0.0; //都不符合
        if (memo.containsKey(a) && memo.get(a).containsKey(b)) return memo.get(a).get(b);
        double p = 0;
        p += search(a - 100, b, memo);
        p += search(a - 75, b - 25, memo);
        p += search(a - 50, b - 50, memo);
        p += search(a - 25, b  - 75, memo);
        p /= 4; //本次发生的概率只有1/4
        if (!memo.containsKey(a)) memo.put(a, new HashMap<Integer, Double>());
        memo.get(a).put(b, p);
        return p;
    }
}
