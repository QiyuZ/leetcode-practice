class Solution {
    public int hIndex(int[] citations) {
        //注意H index取决于paper个数而不是单个的citations，最后结果是0到n的一个数而不是citations的值
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] mark = new int[n + 1]; //多出一个放所有大于等于n的
        for (int c : citations) {
            if (c >= n) mark[n]++;
            else mark[c]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += mark[i];
            if (count >= i) return i;//按照定义，x个paper有至少i个引用x>=n, 从后向前找最大的
            //别有疑问如果引用特别大怎么办，没关系的，只取决于个数[1,100,100] 和[1,2,2]结果一样
        }
        return 0;
    }
}

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) return citations.length - i;
            //此时不能从大往小，因为不确定最后一个bucket有几个，所以反着来，比它小的
        }
        return 0;
    }
}
