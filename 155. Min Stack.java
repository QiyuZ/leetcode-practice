class MinStack {

    Stack<Integer> stack, min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) min.push(x); //保证每回min也push一个，这样始终size一样pop不会出问题
        else min.push(Math.min(x, min.peek()));
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack { //O(1) space - no extra space besides the container for number
    private Stack<Long> stack;
    private long min;
    
    public MinStack() {
        stack = new Stack();
        min = Long.MIN_VALUE;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push((long)(val));
            min = (long)val;
        } else if(val >= min) stack.push((long)(val));
        else {
            stack.push((long)val + val - min);
            min = (long)val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        else if(stack.peek() >= min) stack.pop();            
        else {
            //Bring back the previous min
            min = 2 * min - stack.peek();
            stack.pop();
        }
        if(stack.isEmpty()) min = Long.MIN_VALUE;
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        else if(stack.peek() > min) return (int)(stack.peek().longValue());
        else return (int)(min);
    }
    
    public int getMin() {
        return (int)(min);    
    }
}
