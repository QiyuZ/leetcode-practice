class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.isEmpty() || seqs.size() == 0) return false;
        int count = 0;
        for (List<Integer> seq : seqs) { //这一部分是为了防止当seqs里全是空的但是有好几个而org.length只有1那么match==0就会出错，要检查一遍
            if (seq.size() == 0) count++;
        }
        if (count == seqs.size()) return false;
        int[] mark = new int[org.length + 1];
        boolean[] flag = new boolean[org.length + 1];
        int match = org.length - 1;
        for (int i = 0; i < org.length; i++) mark[org[i]] = i;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) < 1 || seq.get(i) > org.length) return false; //题目说了范围1-n
                if (i == 0) continue; //下面要去i-1所以跳过0
                if (i > 0 && mark[seq.get(i)] <= mark[seq.get(i - 1)]) return false;//index顺序矛盾
                if (flag[seq.get(i - 1)] == false && mark[seq.get(i - 1)] + 1 == mark[seq.get(i)]) { //顺序相邻
                    flag[seq.get(i - 1)] = true;
                    match--;
                }
            }
        }
        return match == 0;
    }
}
//基本思路就是看org每个相邻的是不是在seq里都有对应
