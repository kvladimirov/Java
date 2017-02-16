import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] braces = scanner.nextLine().toCharArray();
        if(braces.length % 2 != 0 || braces.length == 0){
            System.out.println("NO");
            return;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;
        for (char brace : braces) {
            if (brace == '(' || brace == '{' || brace == '[') {
                stack.push(brace);
            } else {
                char currentBrace = stack.pop();
                if (brace == ')') {
                    brace = '(';
                } else if (brace == '}') {
                    brace = '{';
                } else if (brace == ']'){
                    brace = '[';
                }

                if (currentBrace != brace) {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
