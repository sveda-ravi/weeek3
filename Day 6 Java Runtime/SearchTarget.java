import java.util.*;

public class SearchTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dataset Size (N): ");
        int N = sc.nextInt();

        long startTime, endTime;

        startTime = System.nanoTime();
        linearSearch(N);
        endTime = System.nanoTime();
        System.out.println("Linear Search Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        binarySearch(N);
        endTime = System.nanoTime();
        System.out.println("Binary Search Time: " + (endTime - startTime) / 1000000 + "ms");

        sc.close();
    }

    static void linearSearch(int N) {
        for (int i = 0; i < N; i++) {
            if (i == N / 2) break;
        }
    }

    static void binarySearch(int N) {
        int[] arr = new int[N];
        Arrays.sort(arr);
        int target = N / 2;
        int low = 0, high = N - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) break;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
    }
}
