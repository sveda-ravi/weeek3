import java.util.Scanner;

public class MergeSortBookPrices {

    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = prices[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            prices[k++] = leftArr[i++];
        }

        while (j < n2) {
            prices[k++] = rightArr[j++];
        }
    }

    public static void printPrices(int[] prices) {
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        int[] bookPrices = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price for book " + (i + 1) + ": ");
            bookPrices[i] = scanner.nextInt();
        }

        System.out.println("Prices before sorting:");
        printPrices(bookPrices);

        mergeSort(bookPrices, 0, n - 1);

        System.out.println("Prices after sorting in ascending order:");
        printPrices(bookPrices);

        scanner.close();
    }
}
