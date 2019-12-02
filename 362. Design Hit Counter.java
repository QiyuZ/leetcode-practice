// class HitCounter {

//     Queue<Integer> q = null;
//     /** Initialize your data structure here. */
//     public HitCounter() {
//         q = new LinkedList<Integer>();
//     }
    
//     /** Record a hit.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public void hit(int timestamp) {
//         q.offer(timestamp);
//     }
    
//     /** Return the number of hits in the past 5 minutes.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public int getHits(int timestamp) {
//         while (!q.isEmpty() && timestamp - q.peek() >= 300) {
//             q.poll();
//         }
//         return q.size();
//     }
// }

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

class HitCounter {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    
    // store each last get hit timestamp with that bucket
    int[] times;
    // store the number of hit for that bucket
    int[] hits;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        times = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        w.lock();
        try {
            int idx = timestamp % 300;
            if (times[idx] != timestamp) {
                // not in the same 5 minute window
                times[idx] = timestamp;
                hits[idx] = 1;
            } else {
                hits[idx]++;
            }
                    
        } finally {
            w.unlock();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        r.lock();
        try {
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) sum += hits[i];
            }            
        } finally {
            r.unlock();
        }
        return sum;
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
