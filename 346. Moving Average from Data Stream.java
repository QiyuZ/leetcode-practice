class MovingAverage {
    private int size, index, sum;
    private int[] record;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.index = 0;
        this.sum = 0;
        this.size = size;
        this.record = new int[size];
    }
    
    public double next(int val) {
        if (index >= size) {
            int removeIndex = (index - size) % size;
            sum = sum - record[removeIndex] + val;
            record[removeIndex] = val;
            index++;
            return (double)sum / size; //注意此处double要修饰sum否则，是修饰已经算出来的结果
        } else {
            record[index++] = val;
            sum += val;
            return (double)sum / index;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
