class Solution {
    public int totalFruit(int[] tree) { //其实问题就是连续subarrary只有两个数字，最长是多少
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for (int end = 0; end < tree.length; end++) {
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
            while (map.size() > 2) { //同样可以把2替换成任何k
                map.put(tree[start], map.get(tree[start]) - 1);
                if (map.get(tree[start]) == 0) map.remove(tree[start]);
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
