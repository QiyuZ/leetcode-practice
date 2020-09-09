class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\."), s2 = version2.split("\\."); //一定要用//因为Split uses regular expressions, where '.' is a special character meaning anything.
        int len = Math.max(s1.length, s2.length);
        for (int i = 0; i < len; i++) {
            Integer v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            Integer v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            int comp = v1.compareTo(v2);
            if (comp != 0) return comp;
        }
        return 0;
    }
}
