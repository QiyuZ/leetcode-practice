//O(N) prefix sum
class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (int key : map.keySet()) {
            List<Integer> indexes = map.get(key);
            long sum = 0, pre = 0;
            for (int num : indexes) sum += num;
            for (int i = 0; i < indexes.size(); i++) {
                int num = indexes.get(i);
                pre += num;
                res[num] = (i + 1) * (long)num - (pre - num) + sum - pre - (indexes.size() - i) * (long)num;
				//sum of left part  (i + 1) * (long)num - (pre - num)
				//sum of right part sum - pre - (indexes.size() - i) * (long)num
            }
        }
        return res;
    }
}
