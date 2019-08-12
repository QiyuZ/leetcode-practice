class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        int i = 1;
        for (char c : order.toCharArray()) orders[c - 'a'] = i++;
        for (int j = 1; j < words.length; j++) {
            String cur = words[j], pre = words[j - 1];
            if (cur == pre) continue;
            int a = 0, b = 0;
            while (a < cur.length() && b < pre.length()) {
                if (orders[cur.charAt(a) - 'a'] > orders[pre.charAt(b) - 'a']) break; //还要继续比较，不能true
                else if (orders[cur.charAt(a) - 'a'] == orders[pre.charAt(b) - 'a']) {
                    a++;
                    b++;
                } else return false;
            }
            if (a == cur.length() && b != pre.length()) return false;
        }
        return true;
    }
}
