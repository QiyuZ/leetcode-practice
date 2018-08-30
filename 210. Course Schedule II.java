class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int[] indegree = new int[numCourses], res = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses]; //构建图
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        for (int[] p : prerequisites) {
            indegree[p[0]]++; //记录需要先修课的课的入度
            graph[p[1]].add(p[0]); //上了index的课才能上list里面的课
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) { //说明是起点
                queue.offer(i);
                res[index++] = i; //放入结果
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { //其实这里不用图也可以，直接在prerequisites里面一个个找，再判断入度
                int cur = queue.poll();
                for (int classes : graph[cur]) {
                    if (--indegree[classes] == 0) {
                        queue.offer(classes);
                        res[index++] = classes;
                    }
                }
            }
        }
        return index == numCourses ? res : new int[0]; //注意可能有些课冲突无法排序，用index作为判断，不能排序则为空
    }
}
