class Solution {
    public int numSpecialEquivGroups(String[] A) { //feature code, 既然可以变成相同的，而且只问有几个，那么就计算特征有几个即可
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] even = new int[26], odd = new int[26]; //不用stringbuilder 用常数大小数组来节省空间
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (i % 2 == 0) even[cur - 'a']++;
                else odd[cur - 'a']++;
            }
            set.add(Arrays.toString(even) + "*" + Arrays.toString(odd)); //数组变string
        }
        return set.size();
    }
}
