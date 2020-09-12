class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0) return res;
        getCombination(new ArrayList<>(), k, n, 1);
        return res;
    }
    private void getCombination(List<Integer> temp, int count, int target, int cur) {
        if (count == 0 && target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (count < 0 || target < 0) return;
        for (int i = cur; i <= 9; i++) { 
            temp.add(i);
            int index = temp.size() - 1;
            getCombination(temp, count - 1, target - i, i + 1);//因为不允许重复，所以此处是i + 1
            temp.remove(index);
        }
    }
}
