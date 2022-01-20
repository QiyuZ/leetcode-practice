class RandomizedSet {
    Random rand;
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last); //O(1), note can't use linkedlist here as it will cost O(n)
            map.put(last, index);
        }
        map.remove(val);
        list.remove(list.size() - 1); //remove last element in arrayList is O(1), others are O(n). remove object is O(n). linkedlist remove first or last is O(n)
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
