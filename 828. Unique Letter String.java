class Solution {
    public int uniqueLetterString(String s) { // if there're all unque characters
        int pre = 0, cur = 0, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = pre + i + 1;
            sum += cur;
            pre = cur;
        }
        return sum;
    }
}

class Solution {
    public int uniqueLetterString(String s) { // if there could be depulicate
        int pre = 0, cur = 0, sum = 0;
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1); //mark as -1 as for the first oneit's i + 1
        int[] contribution = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur = pre + (i - lastIndex[c - 'A']) - contribution[c - 'A'];
            //it's not i + 1, but just the distance from last one to current (exclude previous one)
            //for the previous valid substring contribution[c - 'A'], they are not going to work, like ABC, append B, then ABCB and BCB are 2 and 1, which is ABC (3) - 1 and BC(2) - 1. B's contribution is 2 
            contribution[c - 'A'] = i - lastIndex[c - 'A'];
            lastIndex[c - 'A'] = i;
            sum += cur;
            pre = cur;
        }
        return sum;
    }
}
