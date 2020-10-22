class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids) {
            if(i > 0) stack.push(i);
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i) stack.pop();
                //这个大上个炸，注意用while因为大的可以一直保持去炸小的
                if (!stack.isEmpty() && stack.peek() > -i) continue; //本个炸
                else if(!stack.isEmpty() && stack.peek() == -i) stack.pop();//两都炸，不同push
                else stack.push(i);
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }
}
