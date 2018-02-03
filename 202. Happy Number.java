class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNum(slow);
            fast = getNum(fast);
            fast = getNum(fast);
        } while (fast != slow);
        return slow == 1;
    }
    //不管是不是快乐数都是有循环
    public int getNum(int n) {
        int sum = 0, temp = 0;
        while (n != 0) {
            temp = n % 10;
            n /= 10;
            sum += temp * temp;
        }
        return sum;
    }
}
