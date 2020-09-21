class LRUCache {
    private int cap;
    private Node head, tail; //dummy node,头尾，防止pre或者next是null
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        removeNode(cur);
        setToHead(cur);
        return cur.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;//别忘了更新value
            get(key); //相同操作直接用get
            return;
        }
        if (map.size() == cap) {
            map.remove(tail.pre.key);//后移除node先map，不然最后一个node已经变了已经变了
            removeNode(tail.pre);
        }
        Node cur = new Node(key, value);
        setToHead(cur);
        map.put(key, cur);
    }  
    
    private void removeNode(Node cur) {
        cur.next.pre = cur.pre;//cur.next.pre之前是cur,现在改成cur.pre, 同理下行
        cur.pre.next = cur.next;
    }
    
    private void setToHead(Node cur) {
        Node next = head.next;
        head.next = cur;
        cur.pre = head;
        next.pre = cur;
        cur.next = next;
    }
    
    private class Node {
        private int key, value;
        private Node pre, next;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
