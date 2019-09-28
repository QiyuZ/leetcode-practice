class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] s = { a, b, c };
        Arrays.sort(s);
        if (s[2] - s[0] == 2) return new int[] {0, 0};
        int min = Math.min(s[1] - s[0], s[2] - s[1]) <= 2 ? 1 : 2;//因为最小的<=2说明只有一个空填上即可，如果不是左右各向中间靠拢，即为两次
        int max = s[2] - s[0] - 1 - 1; //第一个-1是s[1]占据的，第二个-1是相差2其实只有一个空位，得出实际空位数
        return new int[] {min, max};
    }
}
