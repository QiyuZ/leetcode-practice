class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carrier = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            carrier += x + y;
            sb.append(carrier % 10);
            carrier /= 10;
        }
        if (carrier != 0) sb.append(carrier);
        return sb.reverse().toString();
    }
}
