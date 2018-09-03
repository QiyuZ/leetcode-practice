class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false; //相差超过一个肯定不行
        if (s.length() == t.length()) return modify(s, t);
        else if (s.length() > t.length()) return delete(s, t);
        else return delete(t, s); //delete和insert一样的，相对的， s长删掉s的，t长删掉t的
    }
    public boolean modify(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 1; //replace只能一个
    }
    public boolean delete(String s, String t) {
        //acb, ab
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(i)) return s.substring(i + 1).equals(t.substring(j)); //前面相等，检查去掉这个后，剩下的是否相等
        }
        return true;
    }
}
