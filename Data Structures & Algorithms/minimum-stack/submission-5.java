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
        stack.pop();
        preStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return preStack.peek();
    }
}
