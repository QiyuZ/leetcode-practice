class LFUCache {
    private Map<Integer, Integer> values; //记录基本的键值对
    private Map<Integer, Integer> counts; //记录每个出现的次数
    private Map<Integer, LinkedHashSet<Integer>> freq; //因为次数可能相等，所以要记录同一次数的出现顺序，LinkedHashSet可按照插入顺序遍历
    int cap;
    int min; //保持记录最小的次数
    public LFUCache(int capacity) {
        values = new HashMap<>();
        counts = new HashMap<>();
        freq = new HashMap<>();
        this.cap = capacity;
        this.min = 0;
        freq.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if (!values.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        freq.get(count).remove(key); //因为次数+1了，所以要从这里去掉，加到key=count+1里面
        if (count == min && freq.get(count).size() == 0) min++; //注意此时可能去掉后空了即原先只有一个，那么min需要变化
        if (!freq.containsKey(count + 1)) freq.put(count + 1, new LinkedHashSet<Integer>());//检查是否有key=count+1
        freq.get(count + 1).add(key);
        return values.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0) return;
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key); //更新了元素相等于使用了，用get方法更新下counts 和freq
            return;
        }
        if (values.size() >= cap) {
            int deleted = freq.get(min).iterator().next();//找到最小次数的第一个
            freq.get(min).remove(deleted); //三个map分别移除这个
            counts.remove(deleted);
            values.remove(deleted);
        }
        values.put(key, value);//三个元素分别更新
        counts.put(key, 1);
        freq.get(1).add(key);
        min = 1;//更新min
        return;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
