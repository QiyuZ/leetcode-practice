class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list=new ArrayList<>();
        int level = 0;
        int value = label;
        while (value != 0) {
            value = value / 2;
            level++;
        }
        level--; //因为从0 开始，所以当前层-1
        while (level >= 1){
            list.add(0, label);
            int sum = (int)(Math.pow(2, level) - 1 + Math.pow(2, level - 1)); //上一层最大值和最小值
            label = sum - label / 2; //如果两层同方向那么直接除以2，但是此时相邻两层都是相反，所以用总和-原来的值
            level--;
        }
        list.add(0, 1);
        return list;
    }
}
