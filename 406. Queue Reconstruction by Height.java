class Solution {
    public int[][] reconstructQueue(int[][] people) {
         Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));//高的在前面，排位低的在前面
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) res.add(p[1], p);
        //这样插入时，先插高的没人在他前面，这样后面的可直接插入相应位置；如果先处理低的，他绝对位置会一直动
        return res.toArray(new int[people.length][2]);
    }
}
