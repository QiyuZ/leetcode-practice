class Solution {

    int[]psum;
    int total = 0;
    Random rand = new Random();

    public Solution(int[] w) {
        psum = new int[w.length];
        int i = 0;
        for (int x : w) {
            total += x;
            psum[i++] = total;
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(total);
        int lo = 0;
        int hi = psum.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
