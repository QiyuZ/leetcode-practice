class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) sb.append("-"); //判断正负
        long a = Math.abs((long)numerator), b = Math.abs((long)denominator);//转换为long防止越界比如-min_value / -1
        sb.append(a / b);
        long remainder = a % b;
        if(remainder == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>(); //remainder - 潜在的插入左括号位置
        map.put(remainder, sb.length());
        while (remainder != 0) { //两个整数相除一定是有限小数或者无限循环小数，不可能无限不循环， 如果remainder可以等于0说明小数有限， 比如1/8
            remainder *= 10; //想得到小数的一位就相当于乘以10，再除以b取整数部分，再去余数作为下一位的计算来源
            sb.append(remainder / b);
            remainder %= b;
            if (map.containsKey(remainder)) { //如果重复说明有循环
                sb.insert(map.get(remainder), "(");//相当于在重复起前插入
                sb.append(")");
                break;
            } else map.put(remainder, sb.length());
        }
        return sb.toString();
    }
}

