class MyCircularDeque {

    private List<Integer> deque;
    private int front, rear, len;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new ArrayList<>();
        len = k;
        front = -1;
        rear = -1; 
        //这里设为-1而不是0，是因为假设原来里面有一个元素，如果先deletelast rear变为-1，然后insertLast rear则无法变，所以每次如果初始化了再设为0
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (deque.size() == 0) {
            rear = 0; front = 0;
            deque.add(value);
        } else {
            deque.add(0, value);
            rear++;
        }
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (deque.size() == 0) {
            rear = 0; front = 0;
            deque.add(value);
        } else {
            deque.add(value);
            rear++;
        }
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        deque.remove(front);
        rear--;
        return true; 
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        deque.remove(rear--);
        return true; 
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return deque.get(front);
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return deque.get(rear);
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.size() == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return deque.size() == len;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */



class MyCircularDeque {
    
    private int[] arr;
    int head, tail, size;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        head = -1;
        tail = 0;
        size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        // Overflow
        if(isFull()) return false;
        head = (head + 1) % arr.length;
        // Insert Front
        arr[head] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        // Overflow
        if(isFull()) return false;
        if(tail == 0) tail = arr.length - 1; //起始状态，放到最后
        else tail = tail - 1; //否则向前移动
        // Insert Last
        arr[tail] = value;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        // Overflow
        if(isEmpty()) return false;
        if(head == 0) head = arr.length - 1; //回归起始状态，注意此处不是-1，因为可能后面tail还有值
        else head = head - 1;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail = (tail + 1) % arr.length; //注意remove last移动是要向后移,因为最初的放在最后面
        // Insert Front
        size--;
        return true;
        
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[head];
        
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[tail];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}
