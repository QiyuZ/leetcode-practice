class Solution { //2 pointers O(n)
    public String minWindow(String S, String T) { //2 pointers to find the matched substring and go back to start point to get substring
        if (S.equals(T)) return S;
        if (S.length() < T.length()) return "";
        char[] s = S.toCharArray(), t = T.toCharArray();
        String res = "";
        int i = 0, tindex = 0, slen = s.length, tlen = t.length, len = slen + 1;
        while(i < slen) {
            if(s[i] == t[tindex]) {
                tindex++; //move tIndex if find match
                if(tindex == tlen) { // all chars in T has been matched
                    int end = i + 1; //i is the last match index in S
                    tindex--; // now tindex is the last index in T
                    while(tindex >= 0) {  //both i and tindex move back to find the start point
                        if(s[i] == t[tindex]) tindex--;
                        i--;
                    }
                    i++;  //we found the first match index in S
                    tindex++;  //now tindex == 0, the first match index in T
                    if(end - i < len) { //optimization ops
                        len = end - i;
                        res = S.substring(i, end); // [i, end) is the matching subsequence
                    }
                }
            }
            i++; //because whatever case we will move i, so even it back to start, it will move to next one, so not a loop. like "abcdebdde", "bde", after find the start b, it will move to c
        }
        return len == slen + 1 ? "" : res;
    }
}
