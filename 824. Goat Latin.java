class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) return S;
        String[] strs = S.split("\\s+"); //注意是\\s+弄错了就还是一整个S
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder();
        String constantA = "a";
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            if (vowel.contains(Character.toLowerCase(cur.charAt(0)))) sb.append(cur);
            else {
                sb.append(cur.substring(1));
                sb.append(cur.charAt(0));
            }
            sb.append("ma");
            sb.append(constantA);
            constantA += "a"; //注意此处不用循环，每次递增a, 可节约时间, 注意是加“a”不是a,否则每次翻倍
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
//对于有些复杂的操作 goat -> oatgma 没必要先形成这个string再添加，直接在stringbuilder做就行
