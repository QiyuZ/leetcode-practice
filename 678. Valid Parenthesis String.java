class Solution {
    public boolean checkValidString(String s) { //因为*导致数量可变，那么用range来记录
        if (s.isEmpty()) return true;
        int min = 0, max = 0; //代表左括号的相对个数，如果区间是0到某个数则说明可以
        for (char c : s.toCharArray()) {
            if (c == '(') { //左右括号是固定的，所以一定都是++和下面的--
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else if (c == '*') {//min认为是右，max认为是左
                min--;
                max++;
            }
            if (max < 0) return false; //max已经是让左括号尽量多了，如果还小于0则肯定不行
            //这步是必须的因为要防止")("的情况，不能只看最后范围内有没有0
            min = Math.max(0, min); //因为min可能小于0 ，此时max>0所以可以把min调到0，因为最后答案有一个0即可
        }
        return min == 0; 
    }
}
