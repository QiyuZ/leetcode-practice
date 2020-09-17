class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int count = 0, x = 0, y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') count++;
            else if (c == 'R') count--;
            else if (c == 'G') {
                int index = count < 0 ? (4 - Math.abs(count % 4)) % 4 : count % 4;//如果向右是负数则%4取正，注意还有%4防止4
                x += dirs[index][0];
                y += dirs[index][1];
            }
        }
        return (x == 0 && y == 0) || count % 4 != 0; 
        //看是不是回到了起点，或者如果没有面向北，走的多了肯定会有圈,因为具有对称性
    }
}
