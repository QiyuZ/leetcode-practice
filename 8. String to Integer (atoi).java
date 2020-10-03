class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int sign = 1, start = 0;
        long sum = 0;
        if (!str.isEmpty() &&(str.charAt(0) == '+' || str.charAt(0) == '-')) {
            start++;
            sign = str.charAt(0) == '+' ? 1 : -1;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return (int)sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)sum * sign;
    }
}
