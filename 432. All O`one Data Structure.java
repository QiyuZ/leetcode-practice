class AllOne {

    private Map<String, Node> keys; //记录这个str的个数
    private Node head, tail;
    /** Initialize your data structure here. */
    public AllOne() {
        keys = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node node = keys.getOrDefault(key, head);
        Node next = node.next;
        if (next.val != node.val + 1) { //如果不等就新建一个相当于删除了原来的，把这个重新插入，同理删除
            next = new Node(node.val + 1);
            next.insertAt(node.next);
        }
        next.strs.add(key);
        keys.put(key, next);
        if (node != head) node.remove(key);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node node = keys.get(key);
        if (node == null) return;
        if (node.val == 1) {
            keys.remove(key);
            node.remove(key);
            return;
        }
        Node vn = node.pre;
        if (vn.val != node.val - 1) {
            vn = new Node(node.val - 1);
            vn.insertAt(node);
        }
        vn.strs.add(key);
        keys.put(key, vn);
        node.remove(key);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.pre == head) return "";
        return tail.pre.strs.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.strs.iterator().next();
    }
    
    class Node {
        Node pre, next;
        int val;
        Set<String> strs;
        public Node (int val) {
            this.val = val;
            strs = new LinkedHashSet<>();
        }
        void insertAt(Node node) {
            next = node;
            pre = node.pre;
            next.pre = this;
            pre.next = this;
        }
        void remove(String str) {
            strs.remove(str);
            if (strs.isEmpty()) {
                pre.next = next;
                next.pre = pre;
            }
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
