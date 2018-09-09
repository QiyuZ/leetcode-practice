class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        char[] check = new char[]{'(', ')'}; //第一个是要保留的，第二个是要删的
        dfs(s, res, check, 0, 0);
        return res;
    }

    public static void dfs(String s, List<String> res, char[] check, int last_i, int last_j) {
        int count = 0;
        int i = last_i;
        while (i < s.length() && count>= 0) { //找到第一个要删的地方
            if (s.charAt(i) == check[0]) count++;
            if (s.charAt(i) == check[1]) count--;
            i++;
        }

        if (count >= 0)  { //如果count走完还>=0说明没有多余的要删的 ）
            String reversed = new StringBuffer(s).reverse().toString(); //不用重复写一遍，现在要删除的是(, 只需要翻转字符串和check,可以重复利用方法
            if (check[0] == '(') dfs(reversed, res, new char[]{')', '('}, 0, 0);
            else res.add(reversed); //如果是）说明之前已经翻转过，可直接加入

        }

        else {  // extra ')' is detected and we have to do something
            i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
            for (int j = last_j; j<= i; j++) {
                if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j-1) != check[1])) { //删除第一个不正常的
                    //                          是第一个 或者之前的不等于， 比如()a) 这个时候可以删两遍
                    dfs(s.substring(0, j) + s.substring(j+1, s.length()), res, check, i, j);
                }
            }
        }
    }
}
