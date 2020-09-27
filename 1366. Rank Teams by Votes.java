class Solution {
    public String rankTeams(String[] votes) { //标记每个人得到的位置的数量，然后排序 O(26n + (26 ^ 2 * log26))
        if (votes == null || votes.length == 0) return "";
        int n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                char cur = vote.charAt(i);
                if (!map.containsKey(cur)) map.put(cur, new int[n]);
                map.get(cur)[i]++; //得到了第i名，则[i]++
            }
        }
        List<Character> candidates = new ArrayList<>(map.keySet());
        Collections.sort(candidates, (a, b) -> { //sort是最关键的一步，相当于根据所有int[]sort对应的key
            for (int i = 0; i < n; i++) {
                if (map.get(a)[i] == map.get(b)[i]) continue;
                return map.get(b)[i] - map.get(a)[i]; //如果有一个不相等，后面就不用sort了，因为已经确定了它的名次
            } 
            return a - b; //如果两个相等，按照字母顺序排小的在前面，char可以直接减
        });
        return candidates.stream().map(Object::toString).collect(Collectors.joining("")); //直接输出排好序的就是全部的名字包括两个排名一样的
    }
}
