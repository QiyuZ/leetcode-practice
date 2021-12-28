class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {//dont need treemap to sort, because if new key appears that's the larger one just append. 
        if (nums == null || nums.isEmpty()) return new int[] {};
        Map<Integer, List<Integer>> map = new LinkedHashMap<>(); //linked hasmap keeps the insert order of the key
        int n = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!map.containsKey(i + j)) map.put(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));
            }
            n += nums.get(i).size();
        }
        int[] res = new int[n];
        int index = 0;
        for (int key : map.keySet()) {
            for (int j = map.get(key).size() - 1; j >= 0; j--) res[index++] = map.get(key).get(j);
        }
        return res;
    }
}
