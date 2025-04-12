import java.util.Scanner;
import java.util.Stack;

public class MinMaxStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }

        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }

    public Integer pop() {
        if (mainStack.isEmpty()) return null;
        int value = mainStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        if (value == maxStack.peek()) {
            maxStack.pop();
        }
        return value;
    }

    public Integer getMin() {
        if (minStack.isEmpty()) return null;
        return minStack.peek();
    }

    public Integer getMax() {
        if (maxStack.isEmpty()) return null;
        return maxStack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of integers:");
            int n = scanner.nextInt();
            MinMaxStack stack = new MinMaxStack();
            System.out.println("Enter the numbers:");

            for (int i = 0; i < n; i++) {
                stack.push(scanner.nextInt());
            }

            System.out.println("Min: " + stack.getMin());
            System.out.println("Max: " + stack.getMax());
        } finally {
            scanner.close();
        }
    }
}
