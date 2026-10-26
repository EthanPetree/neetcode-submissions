class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque();

        for (String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = switch (s) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new Error();
                };
                stack.push(result);
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }

        return stack.peek();
    }
}
