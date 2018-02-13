class RandomizedSet {
    Map<Integer, Integer> map; //用来记录位置
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (list.contains(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!list.contains(val)) return false;
        if (map.get(val) != list.size() - 1) {
            int pos = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(pos, lastVal);
            map.put(lastVal, pos);
        }
        list.remove(list.size() - 1);
        return true;
        //这里如果直接删除val的位置，后面的位置都会改变，所以先把最后一个数放到要删去数的位置，再删去最后一个即可
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
