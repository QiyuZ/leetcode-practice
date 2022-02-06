class StockPrice {
    private Map<Integer, Integer> timeToPrice; //regular map to record time and price
    private TreeMap<Integer, Integer> priceToCount;//there could be duplicate price at different time, so we need another map for price and count. Because we need to know max and min as well, so treemap can help. Because we cant record second max or min as potential candidate
    private int curTime;
    public StockPrice() {
        timeToPrice = new HashMap<>();
        priceToCount = new TreeMap<>();
        curTime = -1;
    }
    
    public void update(int timestamp, int price) {
        curTime = Math.max(curTime, timestamp); //update current time
        int prePrice = timeToPrice.getOrDefault(timestamp, -1);
        if (prePrice == price) return; //same price, did nothing
        if (prePrice != -1) { //existed, need to update
            int count = priceToCount.get(prePrice);
            if (count - 1 == 0) priceToCount.remove(prePrice); //remove if just 1 count
            else priceToCount.put(prePrice, count - 1);
        }
        priceToCount.put(price, priceToCount.getOrDefault(price, 0) + 1); //update price cound and time to price
        timeToPrice.put(timestamp, price);
    }
    
    public int current() {
        return timeToPrice.get(curTime);
    }
    
    public int maximum() {
        return priceToCount.lastKey();
    }
    
    public int minimum() {
        return priceToCount.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
