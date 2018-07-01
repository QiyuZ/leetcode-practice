class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        for (int i = triangle.size() - 2; i >= 0; i--) {//注意要从下开始，即从目标开始。从上往下会改变元素值
            for (int j = 0; j <= i; j++) //没行之间差一个，所以这里取到i
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        }       //下一行相同的index或者对角线的，比如 5,对应1,8
        return triangle.get(0).get(0);
    }
}
