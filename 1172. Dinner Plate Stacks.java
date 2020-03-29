class DinnerPlates {
    Map<Integer, Stack<Integer>> map;
    int popIndex, pushIndex, capacity;
    public DinnerPlates(int capacity) {
        this.map = new HashMap<>();
        this.pushIndex = 0;
        this.popIndex = 0;
        this.capacity = capacity;
        map.put(pushIndex, new Stack<>());
    }
    
    public void push(int val) {
        while (map.containsKey(pushIndex) && map.get(pushIndex).size() == capacity) pushIndex++; //注意这里是while因为可能插在最前面（上次pop在最前面）后面都满了
        if (!map.containsKey(pushIndex)) map.put(pushIndex, new Stack<>());
        map.get(pushIndex).push(val);
        popIndex = Math.max(popIndex, pushIndex);//pop在最后面
    }
    
    public int pop() {
        if (map.size() == 0) return -1;
        while (popIndex >= 0 && map.get(popIndex).size() == 0) popIndex--; //同理while，可能popAtStack前面都空了要一直找
        if (popIndex == -1) return -1;
        pushIndex = Math.min(pushIndex, popIndex);//push在最前面
        return map.get(popIndex).pop();
    }
    
    public int popAtStack(int index) {
        if (map.size() < index + 1 || map.get(index).size() == 0) return -1;
        pushIndex = Math.min(pushIndex, index);
        return map.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
