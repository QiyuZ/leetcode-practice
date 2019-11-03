class Solution {
    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) freq[text.charAt(i) - 'a']++;
        int s = 0, maxCount = 0, res = 0;
        char maxChar = '#';
        int[] count = new int[26];
        for (int e = 0; e < n; e++) {
            if (++count[text.charAt(e) - 'a'] > maxCount) {
                maxCount = count[text.charAt(e) - 'a'];
                maxChar = text.charAt(e);
            }
            while (e - s + 1 - maxCount > 1) { //区间内最大的不同于maxchar的个数不能大于1
                count[text.charAt(s++) - 'a']--;
            }
            res = Math.max(res, Math.min(e - s + 1, freq[maxChar - 'a'])); //freq[maxChar - 'a']保证后面有可以置换的
        }
        return res;
    }
}
