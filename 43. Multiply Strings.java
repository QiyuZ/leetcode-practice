class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2 + 1]; //可能进一位
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = (len1 - 1) + (len2 - 1) - i - j;
                res[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[index + 1] += res[index] / 10;
                res[index] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i > 0; i--) {
            if (sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        sb.append(res[0]); //第一个独立出去因为可能全是0那种
        return sb.toString();
    }
}
