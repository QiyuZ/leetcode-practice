class Solution {
    public int distinctSubseqII(String S) { //不需要知道具体是什么，知道以某个字母结尾的有几个就行，因为是有先后顺序的，所以不会miss
        long[] endWith = new long[26]; //比如abc a最前面只会有一个，它本身， b，就可以b, ab
        long mod = 1000000007; //注意此处都用long防止越界
        for (char c : S.toCharArray()) {
            endWith[c - 'a'] = Arrays.stream(endWith).sum() % mod + 1;//+1为本身，即使重复比如aa也没关系，因为是加到同一个bucket里面，没有重复计算
        }
        return (int)(Arrays.stream(endWith).sum() % mod); //注意此处要前后都用括号，不然%mod包括不了
    }
}
