import java.util.*;

public class SortingLargeData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dataset Size (N): ");
        int N = sc.nextInt();

        int[] arr = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = rand.nextInt();
        }

        long startTime, endTime;

        startTime = System.nanoTime();
        bubbleSort(arr.clone());
        endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        mergeSort(arr.clone(), 0, N - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        quickSort(arr.clone(), 0, N - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) / 1000000 + "ms");

        sc.close();
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
