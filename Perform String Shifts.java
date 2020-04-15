class Solution {
    public String stringShift(String s, int[][] shifts) {
        if (s.isEmpty() || shifts.length == 0) return s;
        StringBuilder sb = new StringBuilder();
        int mod = s.length(), start = 0;
        for (int[] shift : shifts) {
            int move = Math.abs(shift[1]) % mod;
            if (shift[0] == 0) start = (start + move) % mod;
            else start = (start - move + mod) % mod;
        }
        sb.append(s.substring(start)).append(s.substring(0, start));
        return sb.toString(); 
    }
}
