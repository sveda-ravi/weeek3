import java.util.Scanner;
import java.util.Stack;

public class OptimizedStackExample {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        int maxExpectedSize = expression.length();
        if (maxExpectedSize > 1000000) return false;
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                if (stack.size() >= maxExpectedSize) return false;
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isBalanced(input)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}
