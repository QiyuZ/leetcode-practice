class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        if (pid.size() == 0 || ppid.size() == 0) return res;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        Map<Integer, Set<Integer>> map = new HashMap<>(); //用map，减少时间
        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new HashSet<Integer>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            if (map.containsKey(cur)) { //注意判断是否存在，如果是最后一就没有了
                for (int child : map.get(cur)) queue.offer(child);
            }
        }
        return res;
    }
}


//union find
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int max = 0;
        for (int p: pid) { //最大的一定在pid中，因为即使是root也在pid中有
            max = Math.max(p, max);
        }
        int[] parent = new int[max + 1];
        for (int i = 0; i < parent.length; i++) { //初始化
            parent[i] = i;
        }
        for (int i = 0; i < pid.size(); i++) {
            int p = pid.get(i);
            int pp = ppid.get(i);
            if(p == kill) continue; //把kill作为parent
            int f1 = find(parent, p);
            int f2 = find(parent, pp);
            if (f1 != f2) { //两个应该是一样的
                parent[p] = pp;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (find(parent, i) == kill) {
                list.add(i);
            }
        }
        return list;
    }
    
    private int find(int[] parent, int node) {
        if (parent[node] == node) return node;
        return find(parent, parent[node]);
    }
}
