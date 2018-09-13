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
