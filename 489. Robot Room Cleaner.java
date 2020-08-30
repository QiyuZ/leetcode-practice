/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//题目默认的首先向上，所以这里的顺序是固定的上右下左
    public void cleanRoom(Robot robot) {
        backtrack(robot, 0, 0, new HashSet<String>(), 0); //给定起始点0，0 因为不知道map，所以这里的坐标是相对的坐标
    }
    
    private void backtrack(Robot robot, int x, int y, Set<String> visited, int index) {
        String pos = x + "-" + y;
        visited.add(pos);
        robot.clean(); //别忘了清理当前点
        for (int i = 0; i < dirs.length; i++) {
            int absIndex = (index + i) % 4; 
            //要取绝对的值，因为每次转身后，方向不同要和dirs能对应，比如说先往上走一步，下次向右时，往前走一步其实是相对起始位置的向右
            int newX = x + dirs[absIndex][0], newY = y + dirs[absIndex][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {//没走过要可以走
                backtrack(robot, newX, newY, visited, absIndex);//继续走
                robot.turnRight();//这两行是180°调头
                robot.turnRight();
                robot.move(); //前进一步
                robot.turnRight(); //这两行是再此调头180°调头，返回完全一样的样子
                robot.turnRight(); //比如，向上走一步，没路走要回去，就调头走一步,然后再转过头和之前一样
            }
            robot.turnRight();
        }
    }
}


