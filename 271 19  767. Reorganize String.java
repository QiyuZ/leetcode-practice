class Solution {
    public String reorganizeString(String S) { //插空
        int[] letters = new int[26];
        char maxChar = 'a';
        int maxCount = 0;
        for (Character c : S.toCharArray()) {//找到最大的char和其频率
            letters[c - 'a']++;
            if (letters[c - 'a'] > maxCount) {
                maxCount = letters[c - 'a'];
                maxChar = c;
            }
        }
        char[] res = new char[S.length()];
        if (maxCount > (S.length() + 1) / 2) return ""; //最多的是关键，超过这个肯定不行
        int i = 0;
        while (letters[maxChar - 'a'] > 0) {//现在偶数位填充
            res[i] = maxChar;
            letters[maxChar - 'a']--;
            i += 2;
        }
        for (char c = 'a'; c <= 'z'; c ++){
            while (letters[c - 'a']-- > 0){ //注意此时可能偶数位没有填充完，所以接着走
                if (i >= res.length){//如果偶数位完了，就换到奇数位开头
                    i = 1;
                }
                res[i] = c;
                i += 2;

            }
        }
        return new String(res);
    }
}
