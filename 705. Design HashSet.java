class MyHashSet {
    private boolean[][] set;
    private int bucket = 1000;
    private int item = 1001;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[bucket][];
    }
    
    public void add(int key) {
        int hash = getBucket(key);
        if (set[hash] == null) set[hash] = new boolean[item];
        int pos = posInBucket(key);
        set[hash][pos] = true;
    }
    
    public void remove(int key) {
        if (set[getBucket(key)] != null) set[getBucket(key)][posInBucket(key)] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[getBucket(key)] != null && set[getBucket(key)][posInBucket(key)];
    }
    
    private int getBucket (int key) { //相当于hash 用来确定区域
        return key % bucket;
    }
    
    private int posInBucket (int key) {
        return key / bucket;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


class MyHashSet {
    boolean[] arr = new boolean[100];// start with 100 elements for fast initialization
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(key>=arr.length) // if array is too small to accomodate key, extend it.
            extend(key);
        arr[key]=true;
    }
    
    public void remove(int key) {
        if(key>=arr.length) // if array is too small to accomodate key, extend it.
            extend(key);
        arr[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key>=arr.length) // key cannot be in array if array's length < key
            return false;
        return arr[key]==true;
    }
    
    public void extend(int key){
        arr = Arrays.copyOf(arr, key+1);  // extend array to one more item than necessary, we need "key" items. 
									     // we give "key+1" items to reduce collisions.
    }
}
