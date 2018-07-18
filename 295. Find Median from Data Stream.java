class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();   
        //巧妙利用两个queue，一个从小到大（默认）一个从大到小，保持从大到小的比另一个多一个或相等，这样中位数要么是max的peek要么就是两个peek的平均数
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()) max.offer(min.poll());
    }
    
    public double findMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek()) / 2.0 : max.peek();
    }
}
