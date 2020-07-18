class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            if (!map.containsKey(p[1])) map.put(p[1], new HashSet<>());
            map.get(p[1]).add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);//不要break因为可能有很多个课没有限制，要把没限制的都加进去
        }
        int[] res = new int[numCourses];
        int index = 0; //可能有多重不符合的情况比如整体循环，局部小循环，一个个判断太麻烦，最简单的是记录个数，看符合的是不是最终的numCourses即可
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        return index == numCourses ? res : new int[] {};
    }
}
