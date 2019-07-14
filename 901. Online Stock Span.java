class StockSpanner {
    Stack<int[]> stack; //局部最大价格，局部范围的大小
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) count += stack.pop()[1]; //比如70， 60， 80 要用while往前一直找符合条件的
        stack.push(new int[] {price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
