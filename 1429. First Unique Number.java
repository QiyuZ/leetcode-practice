class FirstUnique {
    private Map<Integer, Integer> map;
    private Queue<Integer> queue; //因为unique的可以有多个，当最前面的重复后后面的补上，所以其实是FIFO
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) add(num);
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) queue.poll();
        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        if (!map.containsKey(value)) queue.offer(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

class FirstUnique {
  private Set<Integer> set = new LinkedHashSet<>();
  private Map<Integer, Integer> map = new HashMap<>();
  public FirstUnique(int[] nums) {
    for (int num : nums) this.add(num);
  }
    
  public int showFirstUnique() { //O(1)
    if (!set.isEmpty()) return set.iterator().next();
    return -1;
  }
    
  public void add(int value) {
      if (!map.containsKey(value)) set.add(value);
      else set.remove(value);
      map.put(value, map.getOrDefault(value, 0) + 1);
  }
}
