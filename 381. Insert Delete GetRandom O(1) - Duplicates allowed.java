class RandomizedCollection {

    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = false;
        if (!map.containsKey(val)) {
            contains = true;
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val).iterator().next(), lastIdx = list.size() - 1, last = list.get(lastIdx);
        map.get(val).remove(idx); // set takes O(1) time to remove any index
        //note!!! here we need to remove first because if idx and lastIdx are in same set, both of them will be removed
        if (map.get(val).isEmpty()) map.remove(val); //note, remove the empty one as it may influence the insert result
        if (idx != lastIdx) {//make last to the index pos
            map.get(last).remove(lastIdx);
            map.get(last).add(idx);
            list.set(idx, last);
        }
        list.remove(lastIdx);

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
