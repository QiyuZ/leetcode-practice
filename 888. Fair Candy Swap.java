class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int a : A) sumA += a;
        Set<Integer> set = new HashSet<>(); //不用set就n2时间了
        for (int b : B) {
            sumB += b;
            set.add(b);
        }
        int diff = (sumA - sumB) / 2;
        for (int a : A) {
            if (set.contains(a - diff)) {
                return new int[] {a, a - diff};
            }
        }
        return new int[] {-1, -1};
    }
}
