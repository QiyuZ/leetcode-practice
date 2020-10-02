class Solution {
    public boolean circularArrayLoop(int[] nums) {//slow - fast 指针
        if (nums == null || nums.length <= 0) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] %= n; //变为(-n, n)不包括边界，好处是如果里面的数特别大或负数特别小那么计算next比较麻烦 
        boolean[] visited = new boolean[n];//防止多次visit
        for (int i = 0; i < n; i++) {
            int slow = i, fast = i;
            if (visited[slow]) continue; 
            while (nums[slow] * nums[getNext(nums, fast)] > 0 && nums[slow] * nums[getNext(nums, getNext(nums, fast))] > 0) { //保证同正同负，即相同方向,注意是并，而且要查三步的
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
                if (visited[slow]) break;
                if (slow == fast) return true;
                visited[slow] = true;
            }
        }
        return false;
    }
    
    private int getNext(int[] nums, int index) {
        return (index + nums[index] + nums.length) % nums.length; //这里注意要+长度因为可能是负数但是因为是不超过-n的所以加一个n就可以
    }
}
