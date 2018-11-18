class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return people;
        Arrays.sort(people, new Comparator<int[]>() {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) res.add(p[1], p); //这个厉害了，因为先插入的是高的，所以这里可以直接排入后面的
        return res.toArray(new int[people.length][2]);
    }
}
