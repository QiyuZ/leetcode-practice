class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int num : A) sum += num;
        if (!possible(sum, A.length)) return false;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= A.length / 2; i++) list.add(new HashSet<Integer>()); //一定有一边个数小于一半
        list.get(0).add(0);
        for (int num : A) { //从0起找出所有可能的和，一个数字的，2个的。。知道一半个数的
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i - 1).size() > 0) {
                    for (int j : list.get(i - 1)) list.get(i).add(j + num);
                }
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (sum * i % A.length == 0 && list.get(i).contains(sum * i / A.length)) return true;
        }
        return false;
    }
    public boolean possible (int sum, int n) {
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0) return true;
        }
        return false;
    }
}
//公式： sum * i = A.length * (某个set的和)
