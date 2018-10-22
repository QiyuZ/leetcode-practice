class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1); //初始化-1
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree[c - 'a'] = 0; //出现过的置为0
            }
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (next[j] != cur[j]) { //注意，一定要是不相等的
                    if (!map.containsKey(cur[j])) map.put(cur[j], new HashSet<>());
                    if (!map.get(cur[j]).contains(next[j])) {
                        map.get(cur[j]).add(next[j]);
                        indegree[next[j] - 'a']++; //别忘了入度+1
                    }
                    break; //break很重要，因为只有第一个不同的是决定顺序的
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer((char)(i + 'a')); //找到初始位置
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);
            if (map.containsKey(cur)) {
                for (char next : map.get(cur)) {
                    indegree[next - 'a']--; //因为已经把当前的取出来了，所以它的孩子入度都要-1
                    if (indegree[next - 'a'] == 0) queue.offer(next);//如果此时入度变为0，说明这个成为新的初始
                }
            }
        }
        for (int num : indegree) { //检查是否都取出
            if (num > 0) return "";
        }
        return sb.toString();
    }
}
