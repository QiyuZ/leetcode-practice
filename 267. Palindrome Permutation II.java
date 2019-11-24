class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 == 0 ? -1 : 1;
        }
        if (odd > 1) return res;
        List<String> list = new ArrayList<>();
        String cur = "";
        for (Character key : map.keySet()) {
            int val = map.get(key);
            if (val % 2 != 0) cur += key;
            for (int i = 0; i < val / 2; i++) list.add(key + ""); //注意此处不是else 因为可能有3个5个之类的此时只需放入一个多于的，剩下的还是要加入list
        }
        dfs(list, cur, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }
    
    private void dfs(List<String> list, String cur, boolean[] visited, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + cur + sb.reverse());
            sb.reverse(); //之前翻转了要转回来
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i - 1).equals(list.get(i)) && !visited[i - 1]) continue; 
            //注意这里用equals ，如果前面是visited[i - 1]=true,说明还在处理上个，可以放入相同的，但是如果false说明此个是起始，上一个相同的处理完成，要跳过避免重复
            if (!visited[i]) {
                visited[i] = true;
                dfs(list, cur, visited, sb.append(list.get(i)), res);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1); //变回来
            }
        }
    }
}
