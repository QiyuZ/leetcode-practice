class Solution {
    public int minMoves(int target, int maxDoubles) {
        if (maxDoubles  == 0) return target - 1;
        int count = 0, steps = 0;
        while (count < maxDoubles && target > 1) {
            if (target % 2 == 1) {
                target--;
                steps++;
            }
            target /= 2;
            count++;
            steps++;
        }
        return target == 1 ? steps : steps + target - 1;
        
    }
}
