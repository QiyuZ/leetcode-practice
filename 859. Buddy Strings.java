class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); i++) {
                count[A.charAt(i) - 'a']++;
            }
            int nums = 0;
            for (int n : count) nums += n != 0 ? 1 : 0;
            return nums < A.length(); //比如ab不行， aab就可以，因为aa可以互换，所以如果完全相等的String中有两个或以上重复的字母即可，所以数个数
        }
        List<Integer> dif = new ArrayList<>(); //一般情况找出不同的位置，然后比较是否可以互换
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) dif.add(i);
            if (dif.size() == 3) return false;
        }
        return A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}
