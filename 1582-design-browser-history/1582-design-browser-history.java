class Node {
    String url;
    Node prev, next;

    Node(String url) {
        this.url = url;
    }
}
class BrowserHistory {
    Node current;
    public BrowserHistory(String homepage) {
        current =new Node(homepage);
    }
    
    public void visit(String url) {
        Node new_url = new Node(url);//new node
        current.next = null;//clear up
        current.next = new_url;//link both
        new_url.prev=current;
        current = new_url; //move curr pointer
    }
    
    public String back(int steps) {
        while(steps-- >0 && current.prev !=null){
            current = current.prev;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(steps-- >0 && current.next !=null){
            current = current.next;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */