class Solution {
    public boolean canArrange(int[] arr, int k) { //归根到底还是看余数，所以都转变为余数放到相应的bucket里面
        int[] bucket = new int[k];
        for (int num : arr) bucket[(num % k + k) % k]++; //注意负数可以转变为k+负数，比如k=5, {-1, 1} {-1, 6} 其实都是{4,1}
        int i = 1, j = bucket.length - 1;
        while (i < j) if (bucket[i++] != bucket[j--]) return false; //1到k-1应该能相互匹配
        return bucket[0] % 2 == 0; //0必须偶数
    }
}
