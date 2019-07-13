class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(); //用set的原因是因为位数是30个且变为1就不会再为0所以最多30个，用数组表示则长度不确定
        Set<Integer> pre = new HashSet<>();
        for (int a : A) {
            Set<Integer> temp = new HashSet<>();
            temp.add(a);
            res.add(a);
            for (int p : pre) {
                temp.add(a | p);
                res.add(a | p);
            }
            pre = temp;
        }
        return res.size();
    }
}
