class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int key : rooms.get(0)) {
            if (!set.contains(key)) {
                queue.offer(key);
                set.add(key);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> cur = rooms.get(queue.poll());
            for (int key : cur) {
                if (!set.contains(key)) {
                queue.offer(key);
                set.add(key);
                }
            }
        }
        return (set.size() == rooms.size()) || (set.size() == rooms.size() - 1 && !set.contains(0));
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms,0,visited);
        for (int i=0;i<n;i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        List<Integer> list = rooms.get(index);
        for (int element: list) {
            dfs(rooms, element, visited);
        }
    }
}
