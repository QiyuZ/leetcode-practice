class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int constant = 1000;
        int n = A.length;
        for (int i = 0; i < n * n; i++) {
            if (A[i / n][i % n] == 1) a.add(new int[] {i / n, i % n});
            if (B[i / n][i % n] == 1) b.add(new int[] {i / n, i % n});
        }
        Map<String, Integer> map = new HashMap<>(); //无论怎么移动相对距离是不变的，所以记录1的位置然后看相对距离相等的有多少个，即为移动后可重合个数
        for (int[] i : a) {
            for (int[] j : b) {
                String key = (i[0] - j[0]) + "-" + (i[1] - j[1]); //特征值法
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int res = 0;
        for (int num : map.values()) { 
            if (num > res) res = num;
        }
        return res;
    }
}

