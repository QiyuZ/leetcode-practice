class Solution {
    
    private static final int QUICKSORTSHOLD = 50;
    private static final int MERGESORTSHOLD = 300;
    
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        if (nums.length < QUICKSORTSHOLD) selectionSort(nums);   
        else if (nums.length < MERGESORTSHOLD) quickSort(nums);
        else mergeSort(nums);
        return nums;
    }
    
    private void selectionSort(int[] nums) { //挨个找按顺序的位置
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) index = j;
            }
            exchange(nums, index, i);
        }
    }
    
    private void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }
    
    private void quickSort(int[] nums, int low, int high){ //左边比基准数小，右边比它大
        if (low >= high) return;
        int l = low, r = high, base = nums[low];
        while (l < r) {
            while (nums[r] >= base && l < r) r--; //注意先走r否则不一定后面换基准数可能把大的换过去
            while (nums[l] <= base && l < r) l++;
            exchange(nums, l, r);
        }
        exchange(nums, low, r);
        quickSort(nums, low, r - 1); //不用包括r因为已经找到了合适的位置
        quickSort(nums, r + 1, high);
    }
    
    private void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
    }
    
    private void mergeSort(int[] nums, int lo, int hi){
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, mid + 1, hi);
    }
    
    private void merge(int[] nums, int preLo, int preHi, int endLo, int endHi){
        if (preLo == endHi) return;
        int lo = preLo;
        int hi = endHi;
        
        int[] newArr = new int[preHi - preLo + 1 + endHi - endLo + 1];
        int index = 0;
        while (preLo <= preHi && endLo <= endHi){
            newArr[index++] = (nums[preLo] < nums[endLo]) ? nums[preLo++] : nums[endLo++];
        }
        while (preLo <= preHi){
            newArr[index++] = nums[preLo++];
        }
        while (endLo <= endHi){
            newArr[index++] = nums[endLo++];
        }
        index = 0;
        while (lo <= hi){
            nums[lo++] = newArr[index++];
        }
    }
    
    private void exchange(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
