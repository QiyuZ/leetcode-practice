class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isvalid(s1) && isvalid(s2) && isvalid(s3) && isvalid(s4)) res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return res;
    }
    public boolean isvalid(String s) {
        if (s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) return false;
        //注意要先判断长度，因为可能过overflow判断是否大于255（int）, 可以单独0但是不能0开头
        return true;
    }
}
