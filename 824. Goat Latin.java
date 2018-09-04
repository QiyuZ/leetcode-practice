class Solution {
    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        String[] Sarray = S.split("\\s+");
        String a = "a";
        StringBuilder sb = new StringBuilder();
        for (String str : Sarray) {
            if (set.contains(str.charAt(0))) sb.append(str + "ma");
            else sb.append(str.substring(1) + str.substring(0, 1) + "ma");
            sb.append(a);
            a += "a"; //每次a递增即可，不用循环+a
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
//对于有些复杂的操作 goat -> oatgma 没必要先形成这个string再添加，直接在stringbuilder做就行
