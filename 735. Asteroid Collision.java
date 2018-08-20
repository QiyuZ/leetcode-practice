class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) { //空地方或者正数，直接加入，注意接下来asteroids[i]是<0了
                stack.push(asteroids[i]);
                continue;
            }
            while (true) {
                int pre = stack.peek();
                if (pre < 0) {  //符号相同，直接加入，注意接下来都是pre>0了
                    stack.push(asteroids[i]);
                    break;
                } else if (pre == -asteroids[i]) { //相等都爆炸
                    stack.pop();
                    break;
                } else if (pre > -asteroids[i]) break; //原来的大，新来的爆炸没操作
                else stack.pop(); //剩下的情况都是 新来的大，大的爆炸，因为还要接着和下一个peek比较，所以先不加入
                if (stack.isEmpty()) { //如果已经空了，直接加入
                    stack.push(asteroids[i]);
                    break;
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }
}
