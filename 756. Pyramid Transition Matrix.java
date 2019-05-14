class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>(); //下层-上层
        for (String str : allowed) {
            String base = str.substring(0, 2);
            String top = str.substring(2);
            List<String> list = map.getOrDefault(base, new ArrayList<>());
            list.add(top);
            map.put(base, list);
        }
        return helper(map, bottom, "", 0);
    }
    
    private boolean helper(Map<String, List<String>> map, String from, String to, int pos) {
        if (from.length() == 1) return true; //到头了
        if (to.length() + 1 == from.length()) return helper(map, to, "", 0); //上一层已经形成好了
        if (pos + 2 > from.length()) return false; //不满足下面的条件了
        List<String> list = map.getOrDefault(from.substring(pos, pos + 2), new ArrayList()); //找出这个对应的上层
        for (String top : list) {
            if (helper(map, from, to + top, pos + 1)) return true; //dfs，因为不一定是近邻的一层
        }
        return false;
    }
}
