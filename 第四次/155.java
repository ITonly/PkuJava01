class MinStack {
    
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    
    public int top() {
        return stack.peek();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()||x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int top = stack.peek();
        stack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }
    }


    //minStackջ��Ԫ��Ϊ��СԪ��
    public int getMin() {
        return minStack.peek();
    }
}
