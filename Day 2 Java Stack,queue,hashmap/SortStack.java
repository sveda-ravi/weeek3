import java.util.*;

public class SortStack {
    private Stack<Integer> stack;

    public SortStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public void sort() {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort();
            insertSorted(temp);
        }
    }

    private void insertSorted(int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertSorted(value);
            stack.push(temp);
        }
    }

    public void printStack() {
        System.out.println("Stack: " + stack);
    }

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();

        sortStack.push(30);
        sortStack.push(10);
        sortStack.push(50);
        sortStack.push(20);
        sortStack.push(40);

        sortStack.printStack();

        sortStack.sort();

        sortStack.printStack();
    }
}
