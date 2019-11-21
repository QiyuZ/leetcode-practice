class SnakeGame {
    private int score, rows, cols;
    private int[][] food;
    private LinkedList<int[]> snake;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) { //此处food是一个个出现相当于是stream,用score可以表示现在是第几个
        this.score = 0;
        this.rows = height;
        this.cols = width;
        this.food = food;
        this.snake = new LinkedList<>();
        snake.add(new int[] {0, 0});
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = new int[] {snake.get(0)[0], snake.get(0)[1]}; //注意不可以直接用get因为会引用地址
        switch (direction) {
            case "U":
                head[0]--; break;
            case "D":
                head[0]++; break;
            case "L":
                head[1]--; break;
            case "R":
                head[1]++; break;
        }
        if (head[0] < 0 || head[0] >= rows || head[1] < 0 || head[1] >= cols) return -1;
        for (int i = 1; i < snake.size() - 1; i++) { //判断有无撞到身上，此时先不用考虑food
            if (snake.get(i)[0] == head[0] && snake.get(i)[1] == head[1]) return -1;
        }
        snake.addFirst(head); //不用一个个移动，因为后一个会覆盖前一个的位置，只需放好第一个，判断是否吃到food,是否需要删除最后一个即可
        if (score < food.length) {
            if (head[0] == food[score][0] && head[1] == food[score][1]) score++;
        }
        if (snake.size() > score + 1) snake.removeLast(); //巧妙比较
        return score;
        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
