public class ZigzagIterator {
    //k-lists
    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator cur = queue.poll();
        int res = (int)cur.next();
        if (cur.hasNext()) queue.offer(cur);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

 public class ZigzagIterator {
//2 lists with O(1) space
    private Iterator<Integer> i, j, tmp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) { tmp = j; j = i; i = tmp; }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
