import java.util.Scanner;

public class HeapSortSalaryDemands {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;

            heapify(arr, heapSize, largest);
        }
    }

    public static void printSalaries(int[] arr) {
        for (int salary : arr) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of job applications: ");
        int n = scanner.nextInt();
        int[] salaryDemands = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter expected salary " + (i + 1) + ": ");
            salaryDemands[i] = scanner.nextInt();
        }

        System.out.println("Salaries before sorting:");
        printSalaries(salaryDemands);

        heapSort(salaryDemands);

        System.out.println("Salaries after sorting:");
        printSalaries(salaryDemands);

        scanner.close();
    }
}
