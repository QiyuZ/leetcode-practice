public String orderString(String s) {
    if (s == null || s.length() == 0) return s;
    int[] count = new int[36];
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) count[c - '0']++;
        else count[c - 'A' + 10]++;
    }
    char[] res = s.toCharArray();
    for (int i = 0; i < res.length; i++) {
        if (Character.isDigit(res[i])) {
            for (int j = 0; j < 10; j++) {
                if (count[j] > 0) {
                    count[j]--;
                    res[i] = (char)(j + '0');
                    break; //just need one here
                }
            }
        } else {
            for (int j = 10; j < 26; j++) {
                if (count[j] > 0) {
                    count[j]--;
                    res[i] = (char)(j + 'A');
                    break;
                }
            }
        }
    }
    return new String(res);
}
