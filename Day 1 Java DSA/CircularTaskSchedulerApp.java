import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    public void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count < position - 1) {
            System.out.println("Invalid position.");
            return;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeByTaskId(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task currentTask = head;
        Task previous = tail;

        do {
            if (currentTask.taskId == id) {
                if (currentTask == head) {
                    head = head.next;
                    tail.next = head;
                } else if (currentTask == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = currentTask.next;
                }

                if (currentTask == head && currentTask == tail) {
                    head = tail = null;
                }

                System.out.println("Task with ID " + id + " removed.");
                return;
            }

            previous = currentTask;
            currentTask = currentTask.next;
        } while (currentTask != head);

        System.out.println("Task ID not found.");
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks to show.");
            return;
        }

        if (current == null) {
            current = head;
        }

        System.out.println("Current Task:");
        displayTask(current);

        current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    private void displayTask(Task task) {
        System.out.println("ID: " + task.taskId + ", Name: " + task.taskName +
                ", Priority: " + task.priority + ", Due Date: " + task.dueDate);
    }
}
public class CircularTaskSchedulerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, pos, priority;
            String name, due;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    due = sc.nextLine();
                    scheduler.addAtBeginning(id, name, priority, due);
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    due = sc.nextLine();
                    scheduler.addAtEnd(id, name, priority, due);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    due = sc.nextLine();
                    scheduler.addAtPosition(pos, id, name, priority, due);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    scheduler.removeByTaskId(id);
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
