import java.util.Scanner;

class FixedStack {
    private int top;
    private int capacity;
    private char[] stack;

    public FixedStack(int size) {
        capacity = size;
        stack = new char[capacity];
        top = -1;
    }

    public boolean push(char ch) {
        if (top == capacity - 1) {
            return false;
        }
        stack[++top] = ch;
        return true;
    }

    public Character pop() {
        if (top == -1) {
            return null;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class StackUnderflowOverflowCheck {
    public static boolean isBalanced(String expr, int maxSize) {
        FixedStack stack = new FixedStack(maxSize);
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                if (!stack.push(ch)) {
                    return false;
                }
            } else if (ch == ')' || ch == '}' || ch == ']') {
                Character top = stack.pop();
                if (top == null) {
                    return false;
                }
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
        int maxSize = 1000;
        if (isBalanced(input, maxSize)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced or Stack Overflow/Underflow");
        }
    }
}
