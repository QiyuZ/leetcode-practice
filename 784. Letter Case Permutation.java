class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        transfer(res, 0, S.toCharArray());
        return res;
    }
    public void transfer(List<String> res, int index, char[] s) {
        if (index == s.length) {
            res.add(new String(s));
            return;
        }
        if (Character.isLetter(s[index])) {
            s[index] = Character.toUpperCase(s[index]); //不用管原来是upper还是lower,变upper再lower就全涉及到了
            transfer(res, index + 1, s);
            s[index] = Character.toLowerCase(s[index]);
        }
        transfer(res, index + 1, s); //如果是数字就继续
    }
}
