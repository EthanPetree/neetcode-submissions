class MinStack {
    Deque<Integer> stack, preStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        preStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!preStack.isEmpty()) {
            if (preStack.peek() < val) {
                preStack.push(preStack.peek());
            } else {
                preStack.push(val);
            }
        } else {
            preStack.push(val);
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
        preStack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int getMin() {
        if(preStack.isEmpty()) return 0;
        return preStack.peek();
    }
}
