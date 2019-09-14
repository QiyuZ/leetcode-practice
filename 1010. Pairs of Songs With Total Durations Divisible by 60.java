class Solution { //similar with 2 sum
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int t : time) count[t % 60]++;
        int res = 0;
        for (int i = 0; i <= 30; i++) { //注意这里是30，不是60否则重复
            if (count[i] == 0) continue;
            if (i == 0 || i == 30) res += (count[i] * (count[i] - 1) / 2); //0，30时只能自己和自己配C n 2
            else res += count[i] * count[60 - i];
        }
        return res;
    }
}
