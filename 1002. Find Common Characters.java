class Solution {
    public List<String> commonChars(String[] A) {
        int[] pre = new int[26];
        for (int i = 0; i < A.length; i++) {
            int[] common = new int[26];
            for (char c : A[i].toCharArray()) common[c - 'a']++;
            if (i == 0) {
                pre = common;
                continue;
            }
            for (int j = 0; j < 26; j++) pre[j] = Math.min(pre[j], common[j]); //对比两个特征数组，取最小即相同
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < pre[i]; j++) res.add((char)('a' + i) + "");
        }
        return res;
    }
}
