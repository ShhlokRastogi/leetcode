class MyQueue {
    Stack<Integer> St;
    Stack<Integer> helperSt;
    public MyQueue() {
        St = new Stack<>();
        helperSt = new Stack<>();
    }
    
    public void push(int x) {
        while(!St.isEmpty()){
            helperSt.push(St.pop());
        }
        St.push(x);
        while(!helperSt.isEmpty()){
            St.push(helperSt.pop());
        }

    }
    
    public int pop() {
        return St.pop();
    }
    
    public int peek() {
        return St.peek();
    }
    
    public boolean empty() {
        return St.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
