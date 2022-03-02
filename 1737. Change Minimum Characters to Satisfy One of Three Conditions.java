class Solution {
    public int minCharacters(String a, String b) {
        if (a.equals(b)) return 0;
        int[] ca = new int[26], cb = new int[26];
        for (char c : a.toCharArray()) ca[c - 'a']++;
        for (char c : b.toCharArray()) cb[c - 'a']++;
        int res = Integer.MAX_VALUE, m = a.length(), n = b.length();
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, m + n - ca[i] - cb[i]); //case 3, make all others same as this char
            if (i > 0) { //pre sum
                ca[i] += ca[i - 1];
                cb[i] += cb[i - 1];
            }
            if (i < 25) {
                res = Math.min(res, m - ca[i] + cb[i]); //case 1, make a smaller, so we change all before in ca and change cb[i] make it larger
                res = Math.min(res, n - cb[i] + ca[i]); //case 2
            }
        } //tricky part, we can ignore i==25, means z. Because when there's z, we need to change another one all smaller, or make them equal, it's actually covered by case 3
        return res;
    }
}
