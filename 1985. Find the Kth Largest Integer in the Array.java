class Solution { //note that in java String 14 > 123, so here we need to compare the length as well
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : Integer.compare(a.length(), b.length()));
        for (String num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,(a,b)->{
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        return nums[nums.length-k];
    }
}
