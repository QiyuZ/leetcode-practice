class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, num, "", target, 0, 0, 0);
        return res;
    }
    public void helper(List<String> res, String num, String path, int target, int pos, long curRes, long preNum) {
        if (pos == num.length() && curRes == target) {
            res.add(path);
            return;
        } 
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break; //说明这个数字是0开头的不成立
            long temp = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) helper(res, num, path + temp, target, i + 1, temp, temp); //第一个数没有操作curRes就等于temp
            else {
                helper(res, num, path + "+" + temp, target, i + 1, curRes + temp, temp);//加法
                helper(res, num, path + "-" + temp, target, i + 1, curRes - temp, -temp);//减法，上一个数就等于-temp
                helper(res, num, path + "*" + temp, target, i + 1, (curRes - preNum) + preNum * temp, preNum * temp);
                //乘号比较特殊因为有优先级的问题，这里先去掉之前的数得到之前的res，pre再和temp相乘再加回去
            }
        }
    }
}
