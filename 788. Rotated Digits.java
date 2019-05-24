class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        if (N <= 1) return 0;
        for (int i = 0; i <= N; i++) {
            char[] chars = (i + "").toCharArray();
            boolean compare = true;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '3' || chars[j] == '4' || chars[j] == '7') {
                    compare = false;
                    break;
                }
                if (chars[j] == '2') chars[j] = '5';
                else if (chars[j] == '5') chars[j] = '2';
                else if (chars[j] == '6') chars[j] = '9';
                else if (chars[j] == '9') chars[j] = '6';
            }
            int changed = Integer.parseInt(new String(chars));
            if (compare && changed != i) res++;
        }
        return res;
    }
    
}
