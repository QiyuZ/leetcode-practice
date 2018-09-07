class LRUCache {
    
    private class Node {
        int key, value;
        Node pre, next;
        public Node(int key, int value) {
            this.key = key; //注意是this.外面的=括号里
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    int cap;
    Node head, tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail; //别忘了相互连接起来
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node); //去掉当前的，然后再放到开头
            insertToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) { //如果已经有了，就更新，并且去掉当前的，然后再放到开头
            Node cur = map.get(key);
            remove(cur);
            insertToHead(cur);
            cur.value = value;
            map.put(key, cur);
        } else {
            if (map.size() == cap) { //超出cap，移除最后一个，注意head tail其实都是dummy 放删的时候要用head.next或者tail.pre
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            Node node = new Node(key, value);
            insertToHead(node); //要先处理完node后再放入map
            map.put(key, node);
        }
    }
    
    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void insertToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }
}
