/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    TreeMap<Integer, Interval> treeMap; // key is the starting time
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        Integer key = treeMap.floorKey(val);
        Interval it = null;
        if (key == null || treeMap.get(key).end + 1 < val) { //最小或最大，则新建一个
            it = new Interval(val, val);
        } else { //在这之中则把前一个更新
            it = treeMap.get(key);
            it.end = Math.max(it.end, val);
        }
        
        if (treeMap.containsKey(it.end + 1)) { //看是否与后一个有交集
            Interval next = treeMap.get(it.end + 1);
            treeMap.remove(it.end + 1);
            it.end = Math.max(it.end, next.end);
        }
        treeMap.put(it.start, it);
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(treeMap.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
