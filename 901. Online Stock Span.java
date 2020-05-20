class StockSpanner {
    private Stack<Stock> stack; //monotonic stack
    private int count;
    public StockSpanner() {
        stack = new Stack<>();
        count = 1;
    }
    //经典算法：单调栈 不用保存之前所有的元素，只留下比当前大的就行，因为比当前小的总会持续进栈出栈，没有必要
    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().num <= price) stack.pop();
        int res = stack.isEmpty() ? count : count - stack.peek().day;
        stack.push(new Stock(count++, price));
        return res;
    }
    
    class Stock {
        private int day, num;
        public Stock(int day, int num) {
            this.day = day;
            this.num = num;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
