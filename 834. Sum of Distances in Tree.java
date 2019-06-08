class Solution {
    int[] res, count;
    List<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N; i++) tree.add(new HashSet<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs1(0, -1);
        return res;
    }
    
    private void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];//有多少个node
            res[root] += res[i] + count[i]; //距离是多少，subtree的距离加上有几个这个的subtree，比如0到1,2+2为rootsubtree的总距离
        }
        count[root]++; //add itself
    }
    
    private void dfs1(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = (count.length - count[i]) + (res[root] - count[i]); 
                     //对于不是i的节点，变远了1；   不用走root到i的路了
            //比如当i=2， 0-1就变成了2-0-1，距离长了1； 但是对于2，3,4,5就不用走0-2这个距离了
            dfs1(i, root);
        }
    }
}
