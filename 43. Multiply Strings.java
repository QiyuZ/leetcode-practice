class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j>= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int back = i + j + 1, front = i + j;
                int sum = res[back] + mult; //顶多是两位不会是3位，因为最大的就是9*9+9=90
                res[back] = sum % 10;
                res[front] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (sb.length() == 0 && num == 0) continue;
            sb.append(num);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
