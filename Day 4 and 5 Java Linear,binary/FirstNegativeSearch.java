import java.util.Scanner;

public class FirstNegativeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                index = i;
                break;
            }
        }

        System.out.println("First negative number index: " + index);

        scanner.close();
    }
}
