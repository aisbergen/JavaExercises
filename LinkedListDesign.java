class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    private int size =0;
    private Node head;
    public MyLinkedList() {
        //MyLinkedList mylinkedlist = new MyLinkedList();
        head=null;
        //size=0;
    }
    
    public int get(int index) {
        if(index<0){
            return -1;
        }
        Node current = head; 
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        
        return current.val;
    }
    
    public void addAtHead(int val) {
        
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node current = head; 
        if(head==null){
            head=newNode;
        }else{
            while(current.next!=null){
                current=current.next;
            }
            
            current.next=newNode;
        }
    }
    
    public void addAtIndex(int index, int val) {
    if (index < 0) return; // guard against invalid index

    if (index == 0) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    } else {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }


}

    public void deleteAtIndex(int index) {
     
        
        //head = current;
        
        if(index<0 || head==null){
            return;
        }
        if(index==0){
            head=head.next;
        }
        else{
            Node current = head; 
            int i=0;
            while(i<index-1){
                i++;
                current=current.next;
            }
            
            if (current.next != null) {
            current.next = current.next.next;
        }
        }
        
        
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
