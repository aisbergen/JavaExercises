public class MinStack {
    Stack<int> vals = new Stack<int>();
    Stack<int> min = new Stack<int>();
    
    public MinStack() {}
    
    public void Push(int val) {
        vals.Push(val);
        if (min.Count == 0 || val <= min.Peek())
        {
            min.Push(val);
        }
        else
        {
            min.Push(min.Peek());
        }
        }
    

    public void Pop() {
        vals.Pop();
        min.Pop();     
    }
    
    public int Top() {
        return vals.Peek();
    }
    
    public int GetMin() {
        return min.Peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(val);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */