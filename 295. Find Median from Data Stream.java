class MedianFinder {
    PriorityQueue<Integer> descend;
    PriorityQueue<Integer> ascend;
    boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {
        ascend = new PriorityQueue<>();
        descend = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        if (even) { //even表示两个一样多，我们要让descend多一个，所以先放ascend再放入descend，反之同理
            ascend.offer(num);
            descend.offer(ascend.poll());
        } else {
            descend.offer(num);
            ascend.offer(descend.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (descend.size() > ascend.size()) return (double)descend.peek();
        double sum = (double)(descend.peek() + ascend.peek());
        return sum / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
