class RangeModule {

    private TreeMap<Integer, Integer> map;
    public RangeModule() {
        map =  new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        if (left >= right) return;
        if (map.size() == 0) {
            map.put(left, right);
            return;
        }
        Integer start = map.floorKey(left); //find the pre start
        if (start == null) start = map.ceilingKey(left); //如果没，说明本次的在最前面，那么找到下一个
        while (start != null && start <= right) { //可能有重叠
            int end = map.get(start);
            if (end >= left) {
                map.remove(start);
                left = Math.min(left, start);
                right = Math.max(right, end);
            }
            start = map.ceilingKey(end); //还没完，可能范围扩大后，和下一个又有了重叠
        }
        map.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer floor = map.floorKey(left);
        return floor != null && map.get(floor) >= right;
    }
    
    public void removeRange(int left, int right) {
        if (left >= right || map.size() == 0) return;
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start < right) {
            int end = map.get(start);
            if (end >= left) {
                map.remove(start);
                if (start < left) map.put(start, left); //这个范围有一段没remove再加上
                if (end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
