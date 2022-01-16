class Solution {
    public String[] divideString(String s, int k, char fill) {
        if (s == null || s.isEmpty()) return new String[] {};
        int n = s.length(), size = n % k == 0 ? n / k : n / k + 1;
        String[] res = new String[size];
        int len = 0, i = 0, index = 0;
        StringBuilder sb = new StringBuilder();
        for (; i < s.length(); i++) {
            if (sb.length() == k) {
                res[index++] = sb.toString();
                sb = new StringBuilder();
                if (s.length() - i < k) break;
            }
            sb.append(s.charAt(i));
        }
        if (sb.length() != k) {
            for (;i < s.length(); i++) sb.append(s.charAt(i));
            for (int j = 0; sb.length() < k; j++) sb.append(fill);
        }
        res[index++] = sb.toString();
        return res;
    }
}
