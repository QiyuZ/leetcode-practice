class FirstUnique {
    private Map<Integer, Integer> map;
    private Queue<Integer> queue; //all candidates
    public FirstUnique(int[] nums) {
        map = new LinkedHashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) == 1) queue.offer(key);
        }
    }
    
    public int showFirstUnique() {
        if (queue.isEmpty()) return -1;
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) queue.poll(); //poll out the unsatisfied ones
        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        if (!map.containsKey(value)) queue.offer(value);//unique? then add to queue
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
