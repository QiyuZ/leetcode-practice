class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth = -1, i = 0; //由于A是0，所以起始值设为-1
        for (char c : seq.toCharArray()) { //大体思路就是，如果有连续的(()), 要让他们交替进行A,B
            if (c == '(') res[i++] = ++depth % 2; //新加的（就深度+1
            else res[i++] = depth-- % 2; //处理完后要深度-1
        }
        return res;
    }
}
