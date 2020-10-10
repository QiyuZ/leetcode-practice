class MyHashMap {
    private boolean[] keys;
    private int[] values;
    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new boolean[100];
        values = new int[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (key >= keys.length) extend(key);
        keys[key] = true;
        values[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return key >= keys.length || !keys[key] ? -1 : values[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (key < keys.length) keys[key] = false;
    }
    
    private void extend (int key) {
        keys = Arrays.copyOf(keys, key + 1);
        values = Arrays.copyOf(values, key + 1);
    } 
}


class MyHashMap {

    private static final int size = 1000;
    private Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[size]; //使用array防止same hash index
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index  = getIndex(key);
        Node node = getNode(index, key);
        if (node.next == null) node.next = new Node(key, value);
        else node.next.value = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index  = getIndex(key);
        Node node = getNode(index, key);
        if (node.next == null) return -1;
        return node.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index  = getIndex(key);
        Node node = getNode(index, key);
        if (node.next == null) return;
        node.next = node.next.next;
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % size; //注意要%size防止越界
    }
    
    private Node getNode(int index, int key) {
        if (nodes[index] == null) {  //注意这个时候不能直接取node赋值，因为这个时候是null，要直接初始化这个Node
            nodes[index] = new Node(-1, -1);
            return nodes[index];
        }
        Node node = nodes[index];
        while (node.next != null && node.next.key != key) node = node.next;
        return node;
    }    
    
    class Node {
        private int key, value;
        private Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
