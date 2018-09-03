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
            //注意区别permutation问题，那个要形成list添加到list<list>里，所以要for循环多次形成list,这个通过index指针控制，form only one list
            s[index] = Character.toUpperCase(s[index]); //不用管原来是upper还是lower,做upper再做lower就全涉及到了
            transfer(res, index + 1, s);
            s[index] = Character.toLowerCase(s[index]);//toLowerCase用法，Character.toLowerCase(XX)具体转化某个，str.toLowerCase(),全部变
            transfer(res, index + 1, s);
        }
        else transfer(res, index + 1, s); //数字就继续
    }
}

/*这样是DFS写法，backtracking可以
        if (Character.isLetter(s[index])) {
            s[index] = Character.toUpperCase(s[index]); //变过去
            transfer(res, index + 1, s);
            s[index] = Character.toLowerCase(s[index]); //变回来
        }
        transfer(res, index + 1, s); //当前字母完成，去下一个，注意没有else */
