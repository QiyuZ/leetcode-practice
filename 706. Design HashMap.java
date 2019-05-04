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
        final ListNode[] nodes = new ListNode[10000];

        public void put(int key, int value) {
            int i = idx(key);
            if (nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            if (nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (nodes[i] == null) return;
            ListNode prev = find(nodes[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        int idx(int key) { return Integer.hashCode(key) % nodes.length;}

        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
