class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = null; //define just one string builder to save memory
        for (String d : dict) {
            sb = new StringBuilder(d);
            for (int i = 0; i < d.length(); i++) {
                char origin = sb.charAt(i);
                sb.setCharAt(i, '*');
                String candidate = sb.toString();
                if (!set.add(candidate)) return true;
                sb.setCharAt(i, origin);
            }
            sb.setLength(0);
        }
        return false;
    }
}

class Solution { //hashing O(26*n*m)
    private static final long mod = (long) Math.pow(10, 20) + 7;
    private static final int multi = 26;
    public boolean differByOne(String[] dict) {
        HashSet<Long> set = new HashSet<>();  
        int len = dict[0].length();
        long[] word2hash = new long[dict.length];
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < len; j++) {
                word2hash[i] = (word2hash[i] * multi + dict[i].charAt(j) - 'a') % mod;
            }
        }
        long base = 1;
        for (int j = len - 1; j >= 0; j--) {
            set.clear();
            for (int i = 0; i < dict.length; i++) {
                long newHash = (word2hash[i] - base * (dict[i].charAt(j) - 'a')) % mod;
                if (!set.add(newHash)) return true;
            }
            base = multi * base % mod;
        }
        return false;
    }
}
