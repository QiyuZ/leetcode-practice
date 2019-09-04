class Solution {
    public int minKBitFlips(int[] A, int K) { //最佳策略依次变是0的位置，因为这样不会重复操作，因为是0，1变化，所以可以算变的次数看此次位置需不需要flip
        Queue<Integer> queue = new LinkedList<>(); //k size sliding window
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (!queue.isEmpty() && queue.peek() + K <= i) queue.poll(); //超过k
            if ((queue.size() + A[i]) % 2 == 0) { //queue.size() 是之前已经filp几次，最多是K次，奇数说明已经是1了跳过
                if (A.length < i + K) return -1; //无法flip因为后面位置不够了
                queue.offer(i);
                res++;
            }
        }
        return res;
    }
}
