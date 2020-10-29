class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        Map<Integer, Set<Integer>> counts = new HashMap<>();
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (!counts.containsKey(count)) counts.put(count, new HashSet<>());
            counts.get(count).add(num);
        }
        int res = 0;
        for (int count = 1; count <= arr.length; count++) {
            if (!counts.containsKey(count)) continue;
            int size = counts.get(count).size();
            if (k != 0) {
                if (k >= size * count) k -= size * count;
                else {
                    res += size - k / count;
                    k = 0;
                }
            } else res += size;
        }
        return res;
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        int count = 0;
        for(int n : values) {
            k -= n;
            if (k < 0) break;
            else count++;
        }
        return map.keySet().size() - count;
    }
}
