import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Deque<String> numbersQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String s : input) {
            if(Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {
                numbersQueue.offer(s);
            } else {
                if (operatorStack.isEmpty()){
                    operatorStack.push(s);
                } else {
                    String lastOperator = operatorStack.peek();
                    if (s.equals("+") || s.equals("-")) {
                        if (lastOperator.equals("(")) {
                            operatorStack.push(s);
                        } else {
                            numbersQueue.offer(operatorStack.pop());
                            operatorStack.push(s);
                        }
                    } else if (s.equals("*") || s.equals("/")) {
                        if (lastOperator.equals("*") || lastOperator.equals("/")) {
                            numbersQueue.offer(operatorStack.pop());
                            operatorStack.push(s);
                        } else {
                            operatorStack.push(s);
                        }
                    } else if (s.equals("(")) {
                        operatorStack.push(s);
                    } else if (s.equals(")")) {
                        while (!operatorStack.peek().equals("(")) {
                            numbersQueue.offer(operatorStack.pop());
                        }
                        //Removing the non-necessary open parenthesis '('
                        operatorStack.pop();
                    }
                }
            }
        }

        System.out.printf("%.2f\n", evaluate(numbersQueue, operatorStack));
    }

    public static double evaluate(Deque<String> numbersQueue, Deque<String> operatorStack){
        Deque<String> postfix = new ArrayDeque<>();
        while (!numbersQueue.isEmpty()){
            postfix.offer(numbersQueue.poll());
        }

        while (!operatorStack.isEmpty()){
            postfix.offer(operatorStack.pop());
        }

        String action = "-+*/";
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : postfix) {
            if (!action.contains(token)) {
                stack.push(Double.valueOf(token));
            } else {
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
