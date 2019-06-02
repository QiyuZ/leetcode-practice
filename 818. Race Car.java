class Solution {
    public int racecar(int target) {
        if (target == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add("0/1");
        queue.offer(new int[] {0, 1});
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == target) return res;
                String s1 = (cur[0] + cur[1]) + "/" + (cur[1] * 2);
                String s2 = cur[0] + "/" + (cur[1] > 0 ? -1 : 1);
                int ap = cur[0] + cur[1], as = cur[1] * 2;
                int rs = cur[1] > 0 ? -1 : 1;
                if (Math.abs(cur[0] + cur[1] - target) < target && !visited.contains(s1)) {
                    queue.offer(new int[] {ap, as});
                    visited.add(s1);
                }
                if (Math.abs(cur[0] - target) < target && !visited.contains(s2)) {
                    queue.offer(new int[] {cur[0], rs});
                    visited.add(s2);

                }
            }
            res++;
        }
        return -1;
    }
}


