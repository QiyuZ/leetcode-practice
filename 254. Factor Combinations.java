class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) return res;
        factorHelper(res, new ArrayList<>(), n, 2);
        return res;
    }
    
    private void factorHelper(List<List<Integer>> res, List<Integer> cur, int n, int factor) {
        for (int i = factor; i * i <= n; i++) { //use sqrt to avoid useless visit and avoid duplicate
            if (n % i == 0) {
                cur.add(i);
                cur.add(n / i);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                factorHelper(res, cur, n / i, i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
//O(sqrt(n)*log(n))
