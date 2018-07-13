class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false; //不够3个肯定不行
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (i >= 2 && num.charAt(0) == '0') break; //开头可以是0，但是不能是0组成的数字，但是可以000
            for (int j = i + 1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(first) == '0' && first + 1 < second) break;
                if (num.charAt(second) == '0' && second + 1 < third) break;
                while (third < n) {
                    Long num1 = Long.parseLong(num.substring(first, second));
                    Long num2 = Long.parseLong(num.substring(second, third));
                    Long res = num1 + num2;
                    if (num.substring(third).startsWith(res.toString())) { //剩下的是以它开头的说明成立接着往后走
                        first = second;
                        second = third;
                        third += res.toString().length(); //注意此处， 新的剩余str是在结果之后
                    } else break;                                                     
                }
                if (third == n) return true;
            }
        }
        return false;
    }
}
