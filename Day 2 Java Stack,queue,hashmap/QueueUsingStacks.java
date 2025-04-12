import java.util.*;

public class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    public Integer dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return null; // Return null if both stacks are empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.pop();
    }

    public void printQueue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue: " + stack2);
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();

        queue.enqueue(40);
        queue.printQueue();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();
    }
}
