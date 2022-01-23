class MaxStack {

    private Node head;
    private Node tail;
    private TreeMap<Integer, List<Node>> map;
    
    public MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        map = new TreeMap<>();
    }
    
    public void push(int x) { //O(logn) coz the treemap
        Node newNode = new Node(x);
        newNode.pre = tail.pre;
        newNode.next = tail;
        tail.pre.next = newNode; //do this before tail.pre, otherwise, it's changed
        tail.pre = newNode;
        if (!map.containsKey(x)) map.put(x, new ArrayList<>());
        map.get(x).add(newNode);
    }
    
    public int pop() { //O(logn) coz the treemap
        int val = tail.pre.val;
        removeNode(tail.pre);
        map.get(val).remove(map.get(val).size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        return val;
    }
    
    public int top() {
        return tail.pre.val;
    }
    
    public int peekMax() {//O(logn) coz the treemap
        return map.lastKey();
    }
    
    public int popMax() {//O(logn) coz the treemap
        int max = peekMax();
        Node maxNode = map.get(max).remove(map.get(max).size() - 1);
        removeNode(maxNode);
        if (map.get(max).isEmpty()) map.remove(max);
        return max;
    }
    
    private void removeNode(Node node) {
        Node pre = node.pre, next = node.next;
        next.pre = pre;
        pre.next = next;
    }
    
    class Node{
        Node pre;
        Node next;
        int val;
        public Node(int x){
            this.val = x;
            this.pre = null;
            this.next = null;
        }
    }
}

class MaxStack {
    private Stack<Integer> stack, max;
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }
    
    public void push(int x) { //note, stack and max should always have same size, max cant only record max, otherwise, max pop, cant find the second one, like 5,1,1
        stack.push(x);
        if (max.isEmpty()) max.push(x);
        else max.push(Math.max(x, max.peek())); 
    }
    
    public int pop() {
        int pop = stack.pop();
        max.pop();
        return pop;
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int peekMax() {
        if (max.isEmpty()) return -1;
        return max.peek();
    }
    
    public int popMax() { //note!! all maxStack related push, pop, need to use func here, otherwise max will be missed
        if (stack.isEmpty()) return -1;
        int popMax = peekMax();
        Stack<Integer> tmp = new Stack<>();
        while (top() != popMax) tmp.push(pop());
        pop();//find the target to pop
        while (!tmp.isEmpty()) push(tmp.pop());
        return popMax;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
