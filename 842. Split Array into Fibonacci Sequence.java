class Solution {
    public List<Integer> splitIntoFibonacci(String S) { //complexity should be O(n!) 因为2^31 - 1有十位，第一个有十个可选，以此类推
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() < 3) return res;
        dfs(S, 0, res);
        return res;
    }
    
    private boolean dfs(String s, int index, List<Integer> res) {
        if (s.length() == index) {
            if (res.size() >= 3) return true;
            return false;
        }
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0' && i > index) break; //可以单个0但是不能多位
            long num = Long.parseLong(s.substring(index, i + 1));
            if (num > Integer.MAX_VALUE) break; //题目中限定了范围
            if (res.size() >= 2 && res.get(res.size() - 1) + res.get(res.size() - 2) < num) break; //已经大了往下更大，不用试了
            if (res.size() <= 1 || res.get(res.size() - 1) + res.get(res.size() - 2) == num) {
                res.add((int)num);
                if (dfs(s, i + 1, res)) return true;
                res.remove(res.size() - 1); //别忘了remove
            }
        }
        return false;
    }
}
