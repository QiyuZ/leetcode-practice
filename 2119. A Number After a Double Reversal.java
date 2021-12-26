class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num >=0 && num <= 9) return true;
        return num % 10 != 0;
    }
}
