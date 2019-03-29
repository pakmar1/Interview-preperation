class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length<1) {
            return 0;
        }

        Stack<Integer> stk = new Stack<>();
        for(String tok: tokens) {
       
            if("+".equals(tok) || "-".equals(tok)|| "*".equals(tok)||"/".equals(tok)) {
                Integer num2 = stk.pop();
                Integer num1 = stk.pop();
                int res = evaluate(num1, num2, tok);
                stk.push(res);
            } 
            else {
                stk.push(Integer.parseInt(tok));
            }
        }
        return stk.pop();
    }

    private int evaluate(int num1, int num2, String opr) {
        switch(opr) {
            case "+":return num1 + num2;
            case "-":return num1 - num2;
            case "*":return num1 * num2;
            case "/":return num1 / num2;
        }
        return 0;
    }
}
