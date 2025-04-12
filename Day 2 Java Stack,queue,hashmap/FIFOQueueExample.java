import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIFOQueueExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> taskQueue = new LinkedList<>();

        System.out.println("Enter the number of tasks:");
        int numTasks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter task " + (i + 1) + ":");
            String task = scanner.nextLine();
            taskQueue.add(task);
        }

        System.out.println("Processing tasks in FIFO order:");
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            System.out.println("Processing: " + task);
        }

        scanner.close();
    }
}
