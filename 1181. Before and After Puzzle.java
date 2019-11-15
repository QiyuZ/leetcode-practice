class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String cur = phrases[i];
            String[] curChars = cur.split(" ");
            String first = curChars[0];
            map.putIfAbsent(first, new HashSet<>());
            map.get(first).add(i);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String cur = phrases[i];
            String[] curChars = cur.split(" ");
            String last = curChars[curChars.length - 1];
            if (!map.containsKey(last)) continue;
            for (int j : map.get(last)) {
                if (i == j) continue;
                res.add(cur + phrases[j].substring(last.length()));
            }
        }
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }
}
