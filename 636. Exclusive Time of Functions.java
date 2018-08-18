class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int pre = 0;
        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] part = log.split(":");
            if (!stack.isEmpty()) res[stack.peek()] += Integer.parseInt(part[2]) - pre;
            pre = Integer.parseInt(part[2]);
            if (part[1].equals("start")) stack.push(Integer.parseInt(part[0]));
            else {
                res[stack.pop()]++; //end是在very end of this second, 所以+1s
                pre++; //因为+1s移动到下一秒
            }
        }
        return res;
    }
}
