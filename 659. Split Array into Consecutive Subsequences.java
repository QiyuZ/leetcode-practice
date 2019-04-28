class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<interval> queue = new PriorityQueue<>((a, b) -> (a.end == b.end ? a.len - b.len : a.end - b.end));
        for (int num : nums) {
            //case1 : num > end + 1 下一个不能连续则poll出之前的并检查是否满足长度，因为题目中说为排序好的
            while (!queue.isEmpty() && queue.peek().end + 1 < num) { 
                if (queue.poll().len < 3) return false;
            }
            if (queue.isEmpty() || queue.peek().end == num) queue.offer(new interval(num, num)); //case2 end = num为空或有overlap则new 新的
            else { //case 3 : num == end + 1
                queue.add(new interval(queue.poll().start, num));
            }
        }
        while (!queue.isEmpty()) { //检查剩下的是否满足长度
            if (queue.poll().len < 3) return false;
        }
        return true;
    }
    
    class interval {
        int start, end, len;
        public interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = end - start + 1;
        }
    }
}
