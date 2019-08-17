class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> cur = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int x : cur) {
                int last = x % 10;
                if (x > 0 && last + K <= 9) list.add(x * 10 + last + K);
                if (x > 0 && last - K >= 0 && last - K != last + K) list.add(x * 10 + last - K); //注意K == 0 时重复
            }
            cur = list;
        }
        return cur.stream().mapToInt(i -> i).toArray();
    }
}

