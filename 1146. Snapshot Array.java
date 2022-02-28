class SnapshotArray {
    TreeMap<Integer, Integer>[] arr;
    int snap;
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        snap = 0;
    }
    
    public void set(int index, int val) {
        if (arr[index] == null) arr[index] = new TreeMap<>();
        arr[index].put(snap, val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        Integer realSnap = arr[index] == null ? null : arr[index].floorKey(snap_id); //防止snap并没有那么多次, null checker to avoid null
        return realSnap == null ? 0 : arr[index].get(realSnap);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
class SnapshotArray { //instead of store whole array for several times, we can use bucket, one bucket for one index, and in the bucket we use map to set snapshot id - value

    private Map<Integer, Integer>[] list;
    int snap;
    public SnapshotArray(int length) {
        list = new HashMap[length];
        snap = 0;
    }
    
    public void set(int index, int val) {
        if (list[index] == null) list[index] = new HashMap<>();
        list[index].put(snap, val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        for (int snap = snap_id; snap >= 0; snap--) {
            if (list[index] != null && list[index].containsKey(snap)) return list[index].get(snap);
        }
        return 0;
    }
}


class SnapshotArray {
    List<int[]>[] record;
    int sid;

    public SnapshotArray(int length) {
        record = new List[length];
        sid = 0;
        for (int i = 0; i < length; i++) {
            record[i] = new ArrayList<>();
            record[i].add(new int[]{0, 0});
        }
    }
    
    public void set(int index, int val) {
        if (record[index].get(record[index].size() - 1)[0] == sid) {
            record[index].get(record[index].size() - 1)[1] = val;
        } else record[index].add(new int[]{sid, val});
    }
    
    public int snap() {
        return sid++;
    }
    
    public int get(int index, int snap_id) {
        int idx = Collections.binarySearch(record[index], new int[]{snap_id, 0}, 
                                           (a, b) -> Integer.compare(a[0], b[0]));
        if (idx < 0) idx = - idx - 2;
        return record[index].get(idx)[1];
    }
}
