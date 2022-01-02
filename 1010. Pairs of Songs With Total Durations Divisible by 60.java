class Solution {
    public int numPairsDivisibleBy60(int[] time) { //we just need to care about remainder of 60  
        if (time == null || time.length == 0) return 0;
        int[] bucket = new int[60];
        for (int t : time) bucket[t % 60]++;
        int res = 0;
        for (int i = 0; i <= 30; i++) { //note we need iterate to 30 to avoid duplicate, like 1, 59; 59, 1. Because 0, 30 are special, we cant directly divide 2
            if (i == 0 || i == 30) res += bucket[i] * (bucket[i] - 1) / 2; //for 0 and 30, they are using the same. So it's pick one and another without duplicate, it's n*(n-1)/2 as C 2 n
            else res += bucket[i] * bucket[60 - i];
        }
        return res;
    }
}
