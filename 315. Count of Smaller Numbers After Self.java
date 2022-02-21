class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int n = nums.length;
        Integer[] res = new Integer[n]; //这里要用Integer,不然后面不能Arrays.asList()
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    //从后面开始，因为后面右边是从0开始，找出每个元素sort的index就是结果
    public int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int start = 0, end = list.size() - 1;
        if (list.get(start) >= target) return 0; //因为有可能插到之前和之后，而一般的二分搜索是在之间，要检查特殊情况
        if (list.get(end) < target) return end + 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (list.get(mid) < target) start = mid + 1;
            else end = mid;
        }
        return start; //每回都是start+1所以结果是返回start，比如1,6插入2，mid=0，新的start=1
    }
}


class Solution { //every time during merge sort we record how many right ones smaller than left one
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n]; // record the index. we are going to sort this array
        for (int i = 0; i < n; i++) indices[i] = i;
        // sort indices with their corresponding values in nums, i.e., nums[indices[i]]
        mergeSort(indices, 0, n, result, nums);
        // change int[] to List to return
        List<Integer> resultToReturn = new ArrayList<Integer>(n);
        for (int i : result) resultToReturn.add(i);
        return resultToReturn;
    }
    private void mergeSort(int[] indices, int left, int right, int[] result, int[] nums) {
        if (right - left <= 1) return;
        int mid = left + (right - left) / 2;
        mergeSort(indices, left, mid, result, nums);
        mergeSort(indices, mid, right, result, nums);
        merge(indices, left, right, mid, result, nums);
    }
    private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
        // merge [left, mid) and [mid, right)
        int i = left; // current index for the left array
        int j = mid; // current index for the right array
        // use temp to temporarily store sorted array
        List<Integer> temp = new ArrayList<Integer>(right - left);
        while (i < mid && j < right) {
            if (nums[indices[i]] > nums[indices[j]]) temp.add(indices[j++]);
            else { // j - mid numbers jump to the left side of indices[i]
                result[indices[i]] += j - mid;
                temp.add(indices[i++]);
            }
        }
        // when one of the subarrays is empty
        while (i < mid) {
            // j - mid numbers jump to the left side of indices[i]
            result[indices[i]] += j - mid;
            temp.add(indices[i++]);
        }
        while (j < right) temp.add(indices[j++]);
        // restore from temp
        for (int k = left; k < right; k++) indices[k] = temp.get(k - left);
    }
}
