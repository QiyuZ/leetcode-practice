class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> stack;
    int max;
    
    public FreqStack() { //要知道count, 又要知道stack的顺序，所以用两个map
        freq = new HashMap<>(); //记录每个的count
        stack = new HashMap<>(); //记录count对应的单个元素
        max = 0;
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (!stack.containsKey(f)) stack.put(f, new Stack<>());
        stack.get(f).add(x);
        max = Math.max(max, f); //时时更新最大值
    }
    
    public int pop() {
        int x = stack.get(max).pop();
        freq.put(x, freq.get(x) - 1);
        if (stack.get(max).size() == 0) max--; //可以不移除空的，注意可以-1因为有3个必然有1,2个的这是一个个来的，比如2233，就是1-（2,3） 2-（2,3）
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
