class Solution {
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void cleanRoom(Robot robot) {
        int[] pos = {0, 0};
        Set<String> visited = new HashSet<String>();
        backtracking(robot, pos, visited, 0);
    }
    
    private void backtracking(Robot robot, int[] pos, Set<String> visited, int p) {
        String position = pos[0] + "," + pos[1];
        if (visited.contains(position)) return;
        visited.add(position);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newP = (p + i) % 4; //计算相对位置
            if (!robot.move()) { 
                robot.turnRight(); 
                continue; 
            }
            int[] newPos = {pos[0] + dirs[newP][0], pos[1] + dirs[newP][1] };
            backtracking(robot, newPos, visited, newP);
            robot.turnRight(); //backtracking; move the robot to its original position and facing direction
            robot.turnRight();
            robot.move();
            robot.turnLeft(); //转到下一个方向
        }
    }
}
