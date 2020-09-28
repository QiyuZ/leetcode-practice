class Solution { //just like gcd
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() == 0 || str1.equals(str2)) return str2;
        if (str2.length() == 0) return str1;
        if (str1.length() > str2.length()) {
            if (str1.startsWith(str2)) return gcdOfStrings(str2, str1.substring(str2.length()));
            else return "";
        } else {
            if (str2.startsWith(str1)) return gcdOfStrings(str1, str2.substring(str1.length()));
            else return "";
        }
    }
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))  return "";
        int len = getLen(str1.length(), str2.length());
        return str1.substring(0, len);
    }
    
    private int getLen(int a, int b) {
        if (b == 0) return a;
        return getLen(b, a % b);
    }
}

