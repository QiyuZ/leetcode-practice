class Solution {
    public int minSwaps(int[] data) { //sliding window, we just need to find the min number of 0's in the window
        if (data == null || data.length < 3) return 0;
        int size = 0;
        for (int d : data) size += d;
        int left = 0, count = 0, res = data.length;
        for (int right = 0; right < data.length; right++) {
            if (right - left + 1 > size) count -= data[left++];
            count += data[right];
            if (right - left + 1 == size) res = Math.min(res, size - count);
        }
        return res;
    }
}
