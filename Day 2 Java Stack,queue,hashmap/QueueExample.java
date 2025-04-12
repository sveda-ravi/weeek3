import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QueueExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simple Queue (FIFO)
        Queue<String> simpleQueue = new LinkedList<>();
        System.out.println("Enter the number of tasks for Simple Queue:");
        int numSimpleQueueTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter tasks for Simple Queue:");
        for (int i = 0; i < numSimpleQueueTasks; i++) {
            String task = scanner.nextLine();
            simpleQueue.add(task);
        }

        System.out.println("\nProcessing Simple Queue (FIFO):");
        while (!simpleQueue.isEmpty()) {
            System.out.println("Processing: " + simpleQueue.poll());
        }

        // Deque (Double-Ended Queue)
        Deque<String> deque = new ArrayDeque<>();
        System.out.println("\nEnter the number of tasks for Deque:");
        int numDequeTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter tasks for Deque (add to front and back):");
        for (int i = 0; i < numDequeTasks; i++) {
            System.out.println("Enter task " + (i + 1) + " to add to the front:");
            String taskFront = scanner.nextLine();
            deque.addFirst(taskFront);

            System.out.println("Enter task " + (i + 1) + " to add to the back:");
            String taskBack = scanner.nextLine();
            deque.addLast(taskBack);
        }

        System.out.println("\nProcessing Deque (FIFO):");
        while (!deque.isEmpty()) {
            System.out.println("Processing: " + deque.pollFirst());
        }

        // Priority Queue (Tasks based on priority)
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        System.out.println("\nEnter the number of tasks for Priority Queue:");
        int numPriorityQueueTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter tasks for Priority Queue (they will be processed based on priority):");
        for (int i = 0; i < numPriorityQueueTasks; i++) {
            String task = scanner.nextLine();
            priorityQueue.add(task);
        }

        System.out.println("\nProcessing Priority Queue (based on priority):");
        while (!priorityQueue.isEmpty()) {
            System.out.println("Processing: " + priorityQueue.poll());
        }

        scanner.close();
    }
}
