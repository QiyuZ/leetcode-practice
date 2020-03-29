class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] uf = new int[s.length()];
        for (int i = 0; i < uf.length; i++) uf[i] = i;
        for (List<Integer> p : pairs) {
            int left = Math.min(p.get(0), p.get(1)), right = Math.max(p.get(0), p.get(1));
            int rootLeft = getRoot(left, uf), rootRight = getRoot(right, uf);
            if (rootLeft != rootRight) uf[rootRight] = rootLeft;//注意是更改root的
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < uf.length; i++) {
            int key = getRoot(i, uf); //注意此处key不是uf[i]要查到root
            if (!map.containsKey(key)) map.put(key, new PriorityQueue<>());
            map.get(key).offer(s.charAt(i));
        }
        char[] res = new char[s.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(getRoot(i, uf)).poll();
        }
        return new String(res);
    }
    
    private int getRoot(int num, int[] uf) {
        if (num == uf[num]) return num;
        int update = getRoot(uf[num], uf);
        uf[num] = update; //这一步很关键，如果path很长会花时间，在这个过程中更新每一个的值，下次查起来就快
        return update;
    }
}
