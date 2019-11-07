class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0) return n;
        Map<Integer, List<Integer>> graph= new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) res++;
            visited[i] = true;
            dfs(i, graph, visited);
        }
        return res;
    }
    
    private void dfs(int i, Map<Integer, List<Integer>> graph, boolean[] visited) {
        for (int next : graph.get(i)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, graph, visited);
            }
        }
    }
}


class Solution {
	public int countComponents(int n, int[][] edges) {
		int[] root = new int[n];
		int cnt = n;
		Arrays.fill(root, -1);
		for(int[] e : edges) {
			int p1 = findP(root, e[0]);
			int p2 = findP(root, e[1]);
			if(p1 == p2) continue;
			else {
				root[p1] = p2;
				cnt--;
				
			}
		}
		return cnt;
	}
	
	int findP(int [] root, int p) {
		if(root[p] == -1) return p;
		root[p] = findP(root, root[p]);
		return root[p];
		
	}
}
