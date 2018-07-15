class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long den = Math.abs((long)denominator);
        long num = Math.abs((long)numerator);
        res.append(num / den);
        if (num % den == 0) return res.toString();
        res.append(".");
        num %= den;
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length()); //记录每个小数位的index，发现相同的（循环）就在那个地方插入（，再在后面插入），就完成了
        while (num != 0) {
            num *= 10; //保证得到的是一位数，借位
            res.append(num / den);
            num %= den; //其实就是除法思想
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            } else map.put(num, res.length());
        }
        return res.toString();
    }
}
/*
1.正负号，注意越界
2.整数部分
3.小数部分 */
