class Solution {
    public String crackSafe(int n, int k) {
        int total = (int)Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("0");
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString()); //保证全部可能情况都在
        if (dfs(n, k, sb, visited, total)) return sb.toString();
        return "";
    }
    private boolean dfs(int n, int k, StringBuilder sb, Set<String> visited, int total) {
        if (total == visited.size()) return true;
        String pre = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String cur = pre + i;
            if (visited.contains(cur)) continue;
            visited.add(cur);
            sb.append(i);
            if (dfs(n, k, sb, visited, total)) return true;
            visited.remove(cur);
            sb.setLength(sb.length() - 1);
        }
        return false;
    }
}

/* 本个字符串的尾部是另一个的首部 比如n=3 k=2 起始为000 取后面00最大限度重叠（长度最小）变为001
sb=0001 再取01
*/
