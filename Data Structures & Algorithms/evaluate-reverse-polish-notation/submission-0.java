class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < tokens.length; i++) {
            try {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            } catch (Exception e) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = switch (tokens[i]) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new Error();
                };

                stack.push(result);
            }
        }

        return stack.peek();
    }
}
