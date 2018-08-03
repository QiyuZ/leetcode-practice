class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        int[] degree = new int[26];
        Map<Character, Set<Character>> map = new HashMap<>();
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] = 1; //标记出来哪几个字母出现
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length); //找最小的因为要对应每个上下字母比较
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    if (!map.containsKey(cur[j]))  map.put(cur[j], new HashSet<Character>());
                    if (map.get(cur[j]).add(next[j])) degree[next[j] - 'a']++; //找出怎么连接的，被连接的入度+1
                    break; //找到最前面的第一个不相等的就不用往后看了
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) queue.offer((char)('a' + i)); //如果degree=1说明是最初标记的，是起始点，应该只有一个
        }
        while (!queue.isEmpty()) {
            char out = queue.poll();
            res.append(out);
            if (map.containsKey(out)) {
                for (char sub : map.get(out)) {
                    if (--degree[sub - 'a'] == 1) queue.offer(sub); //除去它的上节点，如果入度变为1说明这是最新的起点
                }
            }
        }
        if (res.length() == count) return res.toString(); //count这里使用，不相等有重复出现的，则不对
        return "";
    }
}
