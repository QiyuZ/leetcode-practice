class Solution {
    public int uniqueLetterString(String S) {
        if (S == null || S.length() == 0) return 0;
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) Arrays.fill(pos[i], -1);
        int n = S.length(), res = 0, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int index = S.charAt(i) - 'A';
            res = (res + (i - pos[index][1]) * (pos[index][1] - pos[index][0])) % mod; //起始为-1，res=0
            pos[index][0] = pos[index][1]; //更新位置
            pos[index][1] = i;
        }
        for (int i = 0; i < 26; i++) res = (res + (n - pos[i][1]) * (pos[i][1] - pos[i][0])) % mod; 
        //相当于计算最后每个字符出现的个数 比如ABA中第二个A
        return res;
    }
}
/* 找到全部substring再看每个sub有几个单独字符，这复杂度太高
问题转换-> 如何形成只有一个单独字符的sub，然后把每个个数加起来
举例 ABA， 针对第一个A 可以 (A)BA, (AB)A 2个
B： A(B)A, (AB)A,  A(BA), (ABA)  4个
A: AB(A), A(BA) 2个
一共8个
所以针对一个字符找出前两次出现的位置，即可计算中间那个的个数，
corner case: 开头都为-1（因为还没出现，并且index从0 开始）
             结尾都为n, 因为sub以n结尾
             */
