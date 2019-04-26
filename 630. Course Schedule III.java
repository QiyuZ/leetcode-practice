class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1])); //优先考虑结束早的
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a)); //用时多的将会被首先剔除
        int times = 0;
        for (int[] course : courses) {
            times += course[0];
            queue.offer(course[0]);
            if (times > course[1]) times -= queue.poll();
        }
        return queue.size();
    }
}

/*
[[100, 200], [1000, 1250], [200, 1300], [2000, 3200]]

[[5,5],[4,6],[2,6]]


*/
