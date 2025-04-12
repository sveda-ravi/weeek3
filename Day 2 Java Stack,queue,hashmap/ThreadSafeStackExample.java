import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadSafeStackExample {
    private static ConcurrentLinkedDeque<Character> stack = new ConcurrentLinkedDeque<>();

    public static boolean isBalanced(String expression) {
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                Character top = stack.poll();
                if (top == null) return false;
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
