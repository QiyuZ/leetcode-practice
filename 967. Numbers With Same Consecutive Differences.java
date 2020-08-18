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

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 0) return new int[0];
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //特殊情况从0开始的
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            getNum(N - 1, i, K, res);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private void getNum(int n, int cur, int delta, List<Integer> res) {
        if (n == 0) {
            res.add(cur);
            return;
        }
        int up = cur % 10 + delta, down = cur % 10 - delta;
        if (up < 10) getNum(n - 1, cur * 10 + up, delta, res);
        if (down >= 0 && down != up) getNum(n - 1, cur * 10 + down, delta, res); //注意检查下up down是否相等，否则就重复计算相同的了
    }
}

