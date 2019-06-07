class Solution {
    public String maskPII(String S) {
        if (S == null || S.length() == 0) return S;
        if (S.contains("@")) return maskEmail(S);
        else return maskPhone(S);
    }
    
    private String maskEmail(String s) {
        StringBuilder sb = new StringBuilder();
		int index = s.indexOf("@");
		sb.append(s.charAt(0)).append("*****").append(s.charAt(index - 1)).append(s.substring(index));
		return sb.toString().toLowerCase();
    }
    
    private String maskPhone(String s) {
        int count = 0;
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = ch.length - 1; i >= 0; i--) {
            if (Character.isDigit(ch[i])) {
                if (count == 4 || count == 7 || count == 10) sb.append("-");
                if (count < 4) sb.append(ch[i]);
                else sb.append("*");
                count++;
            }
        }
        if (count > 10) sb.append("+");
        return sb.reverse().toString();
    }
}
