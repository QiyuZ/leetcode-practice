class MaxStack {

    Stack<Integer> maxStack;
    PriorityQueue<Integer> helper;
    int max;
    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new Stack<>();
        helper = new PriorityQueue<>(10000, Collections.reverseOrder());
    }
    
    public void push(int x) {
        maxStack.push(x);
        helper.offer(x);
    }
    
    public int pop() {
        int pop = maxStack.pop();
        helper.remove(pop); //别忘记同步删去queue中的
        return pop;
    }
    
    public int top() {
        return maxStack.peek();
    }
    
    public int peekMax() {
        return helper.peek();
    }
    
    public int popMax() {
        int max = helper.poll();
        Stack<Integer> temp = new Stack<>();
        while (!maxStack.isEmpty()) {
            if (maxStack.peek() != max) temp.push(maxStack.pop()); //知道找到max
            else {
                maxStack.pop();
                break;
            }
        }
        while (!temp.isEmpty()) maxStack.push(temp.pop());
        return max;
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
