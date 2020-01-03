class MedianFinder {
     
    PriorityQueue<Integer> formerDecr, laterIncre;
    int count;
    /** initialize your data structure here. */
    public MedianFinder() {
        formerDecr = new PriorityQueue<>((a, b) -> (b - a));
        laterIncre = new PriorityQueue<>();
        count = 0;
    }
    
    public void addNum(int num) {
        if (count % 2 == 0) {//因为奇数个数时要让formerDecr多一个，peek是med，所以起始状态最终是放在formerDecr里面
            laterIncre.offer(num); //大的里面挑小的放入小堆，这样才能保证两个queue是从中间断开的
            formerDecr.offer(laterIncre.poll());
        } else {
            formerDecr.offer(num); //小的里面挑大的放入大堆
            laterIncre.offer(formerDecr.poll());
        }
        count++;
    }
    
    public double findMedian() {
        return count % 2 == 1 ? (double)formerDecr.peek() : (double)(formerDecr.peek() + laterIncre.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
