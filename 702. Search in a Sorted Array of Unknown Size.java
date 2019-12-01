class Solution {
    public int search(ArrayReader reader, int target) {
        int right = 1, left = 0;
        while (reader.get(right) < target) { //可以直接right=10000，但是如果不知道上限的话，可以先翻倍找到上下限
            left = right;
            right = left * 2;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = reader.get(mid);
            if (num == target) return mid;
            else if (num > target) right = mid;
            else left = mid + 1;
        }
        return reader.get(left) == target ? left : -1;
    }
}
