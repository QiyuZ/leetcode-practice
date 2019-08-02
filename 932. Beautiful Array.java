class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> temp = new ArrayList<>();
            for (int a : res) {
                if (2 * a - 1 <= N) temp.add(a * 2 - 1);
            }
            for (int a : res) {
                if (2 * a <= N) temp.add(a * 2);
            }
            res = temp;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//保持左奇右偶，Beautiful Array 加减乘除合并都不会改变，此处相当于递归
