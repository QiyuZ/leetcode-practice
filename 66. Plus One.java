class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int[] res = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length; i > 0; i--) {
            int num = (digits[i - 1] + carry) % 10;
            carry = (digits[i - 1] + carry) / 10;
            res[i] = num;
        }
        res[0] = carry;
        return res[0] == 0 ? Arrays.copyOfRange(res, 1, res.length) : res;
    }
}


public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--){
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            else digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1; //如果第一位是1，其他都是0，所以不用考虑后面的
        return res;
    }
}
