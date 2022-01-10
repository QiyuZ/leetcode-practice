class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null) return null;
        if (a == null || b == null) return a == null ? b : a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0) + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry); //note, don't append 0 at last since there could be no carry needed
        return sb.reverse().toString();
    }
}
