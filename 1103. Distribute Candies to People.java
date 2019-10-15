class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int num = 1;
        for (int i = 0; candies > 0; i++) {
            res[i % num_people] += candies - num > 0 ? num : candies;
            candies -= num++;
        }
        return res;
    }
}
