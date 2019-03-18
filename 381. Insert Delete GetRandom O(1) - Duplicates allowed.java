class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> collections;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        collections = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = false;
        if (!map.containsKey(val)) {
            contains = true;
            map.put(val, new HashSet<>());
        }
        map.get(val).add(collections.size());
        collections.add(val);
        return contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) { 
        if (!map.containsKey(val)) return false;
        int idx = map.get(val).iterator().next(), lastIdx = collections.size() - 1, last = collections.get(lastIdx);
        map.get(val).remove(idx);
        if (map.get(val).isEmpty()) map.remove(val);
        if (idx != lastIdx) { //如果移除的是最后一个，则已经移除过
            map.get(last).remove(lastIdx);
            map.get(last).add(idx);
            collections.set(idx, last); //此处直接把第index个替换成最后一个，再删去最后一个
        }
        collections.remove(lastIdx);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return collections.get(rand.nextInt(collections.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
