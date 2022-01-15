class Solution {
    public int minJumps(int[] arr) { //convert to graph problem and bfs to resolve
        if (arr == null || arr.length < 2) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>()); //value - index
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == arr.length - 1) return step;
                for (int peer : map.get(arr[cur])) {
                    if (visited.add(peer)) queue.offer(peer);
                }
                map.get(arr[cur]).clear(); //although visited can ensure not re-offer to queue, but will revisit, so remove the values to not visit again
                if (cur + 1 < arr.length && visited.add(cur + 1)) queue.offer(cur + 1); //check next one
                if (cur - 1 >= 0 && visited.add(cur - 1)) queue.offer(cur - 1); //check previous one
            }
            step++;
        }
        return arr.length - 1;
    }
}
