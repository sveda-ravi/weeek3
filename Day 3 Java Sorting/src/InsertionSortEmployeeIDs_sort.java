import java.util.Scanner;

public class InsertionSortEmployeeIDs_sort {

    public static void insertionSort(int[] empIDs) {
        int n = empIDs.length;
        for (int i = 1; i < n; i++) {
            int key = empIDs[i];
            int j = i - 1;
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }
            empIDs[j + 1] = key;
        }
    }

    public static void printIDs(int[] empIDs) {
        for (int id : empIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employee IDs: ");
        int n = scanner.nextInt();

        int[] employeeIDs = new int[n];

        System.out.println("Enter " + n + " employee IDs:");
        for (int i = 0; i < n; i++) {
            System.out.print("Employee ID " + (i + 1) + ": ");
            employeeIDs[i] = scanner.nextInt();
        }

        System.out.println("\nBefore Sorting:");
        printIDs(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("After Sorting:");
        printIDs(employeeIDs);

        scanner.close();
    }
}
