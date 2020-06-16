class Solution {
    
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";
        if (validIP6(IP)) return "IPv6";
        else if (validIP4(IP)) return "IPv4";
        else return  "Neither"; 
    }
    
    public boolean validIP6(String s) {
        if (s.length() < 15 || s.length() > 39) return false;
        if (s.charAt(0) == ':' || s.charAt(s.length() - 1) == ':') return false;
        String[] strs = s.split(":");
        if (strs.length != 8) return false;
        for (int i = 0; i < strs.length; i++) {
            String token = strs[i];
            if (token.length() > 4 || token.length() == 0) return false;
            for (char c : token.toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) ) return false;
            }
        }
        return true;
    }
    
    public boolean validIP4(String s) {
        if (s.length() < 7 || s.length() > 15) return false;
        if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') return false;
        String[] strs = s.split("\\.");
        if (strs.length != 4) return false;
        for (int i = 0; i < strs.length; i++) {
            String token = strs[i];
            if (token.length() > 3 || token.length() == 0) return false;
            if (token.length() > 1 && token.charAt(0) == '0') return false;
            int d = 0;
            for (char c : token.toCharArray()) d = d * 10 + c - '0';
            if (d > 255 || d < 0) return false;
        }
        return true;
    }
}
