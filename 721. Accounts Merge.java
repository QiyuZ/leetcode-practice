class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>(); //把email都连起来，有共同的则可以通过DFS找到
        Map<String, String> emailName = new HashMap<>(); //email和name对应起来，方便最后生成结果用
        for (List<String> account : accounts) { 
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!graph.containsKey(email)) graph.put(email, new ArrayList<String>());
                if (!emailName.containsKey(email)) emailName.put(email, name);
                if (i == 1) continue; //第一个没有前面
                String preEmail = account.get(i - 1);
                graph.get(email).add(preEmail); //前后连接
                graph.get(preEmail).add(email);
            }
        }
        Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> cur = new ArrayList<>();
                dfs(graph, cur, visited, email);
                Collections.sort(cur); //题目要求email in order
                cur.add(0, emailName.get(email)); //添加名字
                res.add(cur);
            }
        }
        return res;
    }
    public void dfs(Map<String, List<String>> graph, List<String> cur, Set<String> visited, String email) {
        visited.add(email);
        cur.add(email);
        for (String next : graph.get(email)) {
            if (!visited.contains(next)) dfs(graph, cur, visited, next);
        }
    }
}
