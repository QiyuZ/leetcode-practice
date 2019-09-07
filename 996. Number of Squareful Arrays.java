class Solution {
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        return find(A, new ArrayList<Integer>(), new boolean[A.length], 0);
    }
    
    private int find(int[] A, List<Integer> list, boolean[] used, int res) {
        if (list.size() == A.length) return ++res;
        for (int i = 0; i < A.length; i++) { //注意此处要从0开始而不是上次的i因为前面可能有没有用的
            if (used[i] || (i > 0 && A[i - 1] == A[i] && used[i - 1]) //如果和上一个一样而且上一个没有用到（说明上一个不满足）则跳过本个
                || (list.size() > 0 && !isSquareful(list.get(list.size() - 1) + A[i]))) continue;
            used[i] = true;
            list.add(A[i]);
            res = find(A, list, used, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    private boolean isSquareful(int num) {
        return (double)Math.sqrt(num) == (int)Math.sqrt(num);
    }
}
