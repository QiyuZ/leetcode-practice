class Solution {

    private int[] psum;
    private int total;
    private Random rand;

    public Solution(int[] w) { //n time to build
        psum = new int[w.length];
        total = 0;
        rand = new Random();
        int i = 0;
        for (int x : w) {
            total += x;
            psum[i++] = total;
        }
    }

    public int pickIndex() { //logn find time
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


class Solution {
    private TreeMap<Integer, Integer> map;
    private int sum;
    private Random random;
    public Solution(int[] w) { //nlogn build time, because lgn for treemap
        random = new Random();
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }
    
    public int pickIndex() {
        int randNum = random.nextInt(sum) + 1; //nextInt右边不包括所以+1变为[1, sum]
        int key = map.ceilingKey(randNum);//选取的数如果在就选，不在就找它的上限, logn find time
        return map.get(key);
    }
}
