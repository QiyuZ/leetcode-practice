class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];//注意用Integer, 因为后面Arrays.asList是要变为List<Integer>
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;//每个初始为1
            for (int j = i - 1; j > 0; j--) {//如果展开看，每一行中间的(非第一个或者最后一个)，都是前面的和
                res[j] += res[j - 1];//比如1,3,3,1的3就相当于是之前同一位置的2加上它前面的1 1+2=3
            }
        }
        return Arrays.asList(res);
    }
}
