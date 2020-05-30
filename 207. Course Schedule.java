class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { //Topological sort
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            if (!map.containsKey(p[1])) map.put(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
            indegree[p[0]]++; //入度+1，入度为0的即为初始点(可能多个)
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);//可能多个，比如3个但是关系只有[0, 1]
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses; //有没count的说明形成了环indegree不能变为0
    }
}
