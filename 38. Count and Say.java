class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) return s;
        int count = 1;
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder(); //重新生成sb
            for (int j = 0; j < s.length(); j++) {
                if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) count++;
                else {
                    sb.append(count + "" + s.charAt(j));
                    count = 1; //重新置为1
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
