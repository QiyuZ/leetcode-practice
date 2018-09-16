class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> zero = Arrays.asList(""), one = Arrays.asList("0", "1", "8");
        if (n == 0) return zero;
        if (n == 1) return one;
        int index = n % 2 == 0 ? 2 : 3; //因为每次加两个所以要从2或者3开始
        List<String> res = index == 2 ? zero : one; //res也要相应的变化
        while (index <= n) {
            List<String> cur = new ArrayList<>();
            for (String s : res) {
                if (index != n) cur.add("0" + s + "0"); //如果走到最后一轮就不能加00了，数字不成立
                cur.add("1" + s + "1");
                cur.add("6" + s + "9");
                cur.add("9" + s + "6");
                cur.add("8" + s + "8");
            }
            index += 2; //每次加2个数字
            res = cur;
        }
        return res;
    }
}
