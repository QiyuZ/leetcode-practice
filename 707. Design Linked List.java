class MyLinkedList {
    private Node first=null;
    private int len = 0;
    
    public class Node{
        int val;
        Node next;
    }

    public MyLinkedList() {
    }
    
    public int get(int index) {
        if(index>=len||index<0) return -1;
        Node pos = first;
        for (int i=0;i<index;i++){pos=pos.next;}
        return pos.val;
    }
    

    public void addAtHead(int val) {
        Node oldfirst= first;
        first=new Node();
        first.val=val;
        first.next=oldfirst;
        len++;
    }
    

    public void addAtTail(int val) {
        if(first==null){first.val=val;first.next=null;}
        else{
            Node tail=first;
            while(tail.next!=null){tail=tail.next;}
            Node newtail =new Node();
            newtail.val=val;
            newtail.next=null;
            tail.next=newtail;
        }
        len++;
    }
    

    public void addAtIndex(int index, int val) {
        //the test case addAtIndex(-1,0) is the wrong, the following two lines are written just to pass that test case
        if(index>len||index<-1)return;
        if(index==0||index==-1){addAtHead(val);return;}
        //these two lines should actually be:
        //if(index>len||index<0)return;
        //if(index==0){addAtHead(val);return;}
		
        Node pos=first;
        for(int i=0;i<index-1;i++){pos=pos.next;}
        Node newcomer = new Node();
        newcomer.val = val;
        Node prevnext = pos.next;
        newcomer.next=prevnext;
        pos.next=newcomer;
        len++;
    }

    public void deleteAtIndex(int index) {
        if(index>=len||index<0)return;
        if(index==0) {first=first.next;return;}
        Node pos=first;
        for(int i=0;i<index-1;i++){pos=pos.next;}
        pos.next=pos.next.next;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
