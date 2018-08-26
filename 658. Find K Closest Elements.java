class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || k == 0) return res;
        int start = 0, end = arr.length - k;//问题转化为找起始点的位置，最小可以从0开始，最大也必须是arr.length - k开始
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)) start = mid + 1; //左边的距离大，那么start应该mid+1
            else end = mid;
        }
        for (int i = start; i < start + k; i++) res.add(arr[i]);
        return res;
    }
}
