class MyStack {
    Queue<Integer> Q;
    Queue<Integer> helperQ;

    public MyStack() {
        Q = new LinkedList<>();
        helperQ = new LinkedList<>();
    }

    public void push(int x) {
        while (!Q.isEmpty()) {
            helperQ.offer(Q.poll());
        }

        Q.offer(x);

        while (!helperQ.isEmpty()) {
            Q.offer(helperQ.poll());
        }
    }

    public int pop() {
        return Q.poll();
    }

    public int top() {
        return Q.peek();
    }

    public boolean empty() {
        return Q.isEmpty();
    }
}
