import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
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

        while (!numbersQueue.isEmpty()){
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()){
            System.out.print(operatorStack.pop() + " ");
        }
        System.out.println();
    }
}
