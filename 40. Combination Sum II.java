class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int start, int target, List<Integer> currList){
        if(target == 0){
            result.add(new ArrayList<>(currList));
            return;
        }
        if(start == candidates.length || target < candidates[start]) return ;
        int idx = start + 1, num = candidates[start];
        while(idx < candidates.length && candidates[idx] == num) idx++; // get the index of the next distinct candidate
        // case 1: do not use `num`
        backtrack(candidates, idx, target, currList);
        // case 2: use `num`
        for(int i = start; i < idx; i++){
            currList.add(candidates[i]);
            target -= num;
            backtrack(candidates, idx, target, currList);
        }
        for(int i = 0; i < idx - start; i++) currList.remove(currList.size() - 1);
        //移除本次用到的所有的
    }
}
