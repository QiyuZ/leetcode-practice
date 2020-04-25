class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (arr[cur] == 0) return true;
            int next1 = cur + arr[cur], next2 = cur - arr[cur];
            if (next1 >= 0 && next1 < arr.length && visited.add(next1)) {
                queue.offer(next1);
            }
            if (next2 >= 0 && next2 < arr.length && visited.add(next2)) {
                queue.offer(next2);
            }
        }
        return false;
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;
        if (arr[start] == 0) return true;
        int jump = arr[start];
        arr[start] = -1; //mark as visited
        return canReach(arr, start - jump) || canReach(arr, start + jump);
    }
}
