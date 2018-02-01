//O(n)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] mark = new int[n + 1]; //多出来这个是放比长度还大的数，因为不可能到，所以放一起就行比如1,100，长度没有100
        for (int c : citations) {
            if (c >= n) mark[n]++;
            else mark[c]++; //用value作为key
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += mark[i];//累加大的
            if (count >= i) return i;
        }
        return 0;
    }
}
//O(nlogn)，这个就是按照定义来，注意不能从后向前循环否则当所有元素大于长度时会错比如11,15返回1，但是应该是2
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) return citations.length - i;
        }
        return 0;
    }
}
