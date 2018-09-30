class Solution {
    public String frequencySort(String s) {
        if (s.length() <= 2) return s;
        char[] record = new char[128];
        char[] chars = s.toCharArray();
        for (char c : chars) record[c]++; //char也可以用数字表示
        int pos = 0;
        while (pos < chars.length) {
            char max = 0;
            for (char k = 0; k < 128; k++) {
                if (record[k] > record[max]) max = k;
            }
            while (record[max] > 0) {
                chars[pos++] = max;
                record[max]--;
            }
        }
        return new String(chars);
    }
}
