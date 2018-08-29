class TwoSum {
    Map<Integer, Integer> map; //这种2 sum问题首先考虑map方法
    int min, max;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
        int min = Integer.MAX_VALUE; //时刻记录最大最小，来优化
        int max = Integer.MIN_VALUE;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        min = Math.min(min, number);
        max = Math.max(max, number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (value > max * 2 || value < min * 2) return false; //如果超出上下限则不需要遍历，直接false;
        for (int key : map.keySet()) {
            int remain = value - key;
            if ((remain == key && map.get(remain) > 1) || (remain != key && map.containsKey(remain))) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
