class Solution {
    public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, day = 0, n = A.length;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty()) day = A[i][0]; //like if this is the first time or there's gap between events like [1,2] [4,5]...then need to set day as 4
            while (i < n && A[i][0] <= day) pq.offer(A[i++][1]); //the event has been started, add it to the queue
            pq.poll(); //attend the one that cloest to the end date
            res++; //only one event one day
            day++; //so need to update day every time
            while (!pq.isEmpty() && pq.peek() < day) pq.poll(); //the event has been expired
        }
        return res;
    }
}
