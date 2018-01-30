class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        int[] temp = Arrays.copyOfRange(nums, 0, n);
        Arrays.sort(temp);
        int large = n / 2 - (n % 2 == 0 ? 1 : 0);
        int small = n - 1;
        for (int i = 0, j = 1; i < n; i += 2, j += 2) {
            if (j < n) nums[j] = temp[small--];
            nums[i] = temp[large--];
        }
    }
}

//O(n) O(1)
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int median = select(nums, nums.length / 2);
        int left = 0, i = 0, right = nums.length - 1, N = nums.length;
        while (i <= right) {
            if (nums[mapIndex(i, N)] > median)
                swap(nums, mapIndex(i++, N), mapIndex(left++, N));
            else if (nums[mapIndex(i, N)] < median)
                swap(nums, mapIndex(i, N), mapIndex(right--, N));
            else
                i++;
        }
    }
    private int mapIndex(int i, int n) {
        return (1 + (2 * i)) % (n | 1); // for {0, 1, 2, 3, 4, 5}: 0 -> 1  and  3 -> 0
    }
    
    private int select(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length -1;
        while (hi > lo) {
            int j = partition(nums, lo, hi);
            if (j == k) break;
            if (j < k) lo = j + 1;
            else hi = j - 1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v)
                if (i >= hi) break;
            while (v < nums[--j])
                if (j <= lo) break;
            if (i < j)
                swap(nums, i, j);
            else
                break;
        }
        swap(nums, lo, j);
        return j;
    }
    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
