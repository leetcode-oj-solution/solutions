public class Solution {
    public int evalRPN(String[] tokens) {
        MyStack stack = new MyStack(tokens.length);
        for (String s: tokens) {
            if (isOperator(s)) {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(doOperation(a, b, s));
            } else {
                // suppose only there are operators and digits in the array
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
    
    private String doOperation(String operand1, String operand2, String operator) {
        int op1 = Integer.parseInt(operand1);
        int op2 = Integer.parseInt(operand2);
        int r = 0;
        if (operator.equals("+")) {
            r = op1 + op2;
        } else if (operator.equals("-")) {
            r = op1 - op2;
        } else if (operator.equals("*")) {
            r = op1 * op2;
        } else if (operator.equals("/")) {
            r = op1 / op2;
        } else {
            // error handling
        }
        return Integer.toString(r);
    }
    
    protected static class MyStack {
        private String[] stack;
        int index = 0;
        
        public MyStack(int length) {
            stack = new String[length];
        }
        
        public void push(String s) {
            if (index == stack.length) {
                // stack is full
                return;
            }
            stack[index++] = s;
        }
        
        public String pop() {
            if (index == 0) {
                // stack is empty
                return null;
            }
            return stack[--index];
        }
    }
}