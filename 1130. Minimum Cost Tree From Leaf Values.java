class Solution {
    public int mctFromLeafValues(int[] arr) { //题目可以转换为按照顺序，a*b留下较大的数，累加积，最后和是多少
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for (int right : arr) {
            while (right > stack.peek()) { //因为一直要留下最大的数字，所以遇到较大的那个就用来计算，并且留下，而且这样保证一次计算是从小到大，保证结果最小
                int mid = stack.pop();
                int left = stack.peek();
                res += mid * Math.min(left, right); //此处要筛选，因为左右不一定哪个小，举例 3,2,4
            }
            stack.push(right);
        }
        while (stack.size() > 2) res += stack.pop() * stack.peek(); //先pop这样较大的数就留在了stack里面
        return res;
    }
}
