class PhoneDirectory {
    private boolean[] phones;
    private Queue<Integer> releasedQueue;
    private int pointer;
    public PhoneDirectory(int maxNumbers) {
        phones = new boolean[maxNumbers];
        releasedQueue = new LinkedList<>();
        pointer = 0;
    }
    
    public int get() {
        if (pointer < phones.length) {
            phones[pointer] = true;
            pointer++;
            return pointer - 1;
        }
        if (releasedQueue.isEmpty()) return -1;
        int num = releasedQueue.poll();
        phones[num] = true;
        return num;
    }
    
    public boolean check(int number) {
        return !phones[number];
    }
    
    public void release(int number) {
        if (phones[number]) releasedQueue.offer(number);
        phones[number] = false;
    }
}
