class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses]; //构建图
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++; //记录入度
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) { //入度是0 的是起点。放入队列，别忘了记录count
                queue.offer(i);
                count++;
            } 
        }
        while (!queue.isEmpty()) {
            int course = (int)queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int)graph[course].get(i);
                if (--degree[pointer] == 0) {
                    queue.offer(pointer); //减去这条边后入度为0 的是新的起点
                    count++;
                }     
            }
        }
        if (count == numCourses) return true;
        return false;
    }
}
