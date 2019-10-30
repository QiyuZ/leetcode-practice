class SnapshotArray {
    TreeMap<Integer, Integer>[] arr;
    int snap;
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new TreeMap<Integer, Integer>();
            arr[i].put(0, 0); //防止直接snap 然后get
        }
        snap = 0;
    }
    
    public void set(int index, int val) {
        arr[index].put(snap, val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        int realSnap = arr[index].floorKey(snap_id); //防止snap并没有那么多次
        return arr[index].get(realSnap);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */



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
