class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append((char)(--n % 26 + 'A')); //满26加一位，所以思路就是取余数知道后面的数字，除以26往前进,注意先-1，否则最后会多个1
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
