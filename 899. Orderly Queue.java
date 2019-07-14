class Solution {
    public String orderlyQueue(String S, int K) {
        if (K > 1) { //其实只要k>=2就可以实现排序，因为不限制moves每次都可以实现多移动一位
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {  //当K=1，其实就是每一位字母轮流当开头，其他顺序不变，即sub i 放前面
            String cur = S.substring(i) + S.substring(0, i);
            if (res.compareTo(cur) > 0) res = cur;
        }
        return res;
    }
}
