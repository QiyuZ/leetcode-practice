class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) res.add(i ^ (i / 2)); //格雷码可以由十进制转换来
        return res;
    }
}
