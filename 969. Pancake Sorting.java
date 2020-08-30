class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        for (int i = A.length; i > 0; i--) { //注意是A.length从最大的数找，然后把那个数放到最前面再反转到对应的位置，比如首先处理3， 132 -> 312 -> 213
            if (A[i - 1] == i) continue;
            int index = A.length - 1;
            while (A[index] != i) index--;
            reverse(A, index);
            res.add(index + 1);
            reverse(A, i - 1);
            res.add(i);
        }
        return res;
    }
    
    private void reverse(int[] A, int end) {
        int start = 0;
        while (start < end) {
            int temp = A[start];
            A[start++] = A[end];
            A[end--] = temp;
        }
    }
}
