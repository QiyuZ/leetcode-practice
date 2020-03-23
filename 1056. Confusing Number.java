class Solution {
    public boolean confusingNumber(int N) {
        int[] map = new int[] {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int rotated = 0, copy = N;
        while (copy != 0) {
            if (map[copy % 10] == -1) return false;
            rotated = map[copy % 10] + rotated * 10;
            copy /= 10;
        }
        return rotated != N;
    }
}
