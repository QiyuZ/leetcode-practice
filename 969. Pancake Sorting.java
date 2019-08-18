class Solution {
    public List<Integer> pancakeSort(int[] A) { 
        //返回任意成立即可，所以最简单思路，找最大的，放到最后，依次进行；注意不能找最小放在前面因为前面会一直变动，后面不动就考虑后面
        int m = A.length;
        List<Integer> res = new ArrayList<>();
        while (m > 0) {
            int i = 0;
            for (; i < A.length; i++) {
                if (A[i] == m) break;
            } 
            res.add(i + 1); //找到最大
            reverse(A, 0, i); //最大放在前面
            reverse(A, 0, m - 1); //再次翻转放到后面
            res.add(m--);
        }
        return res;
    }
    
    private void reverse(int[] A, int i, int j) {
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++; j--;
        }
    }
}
