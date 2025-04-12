import java.util.*;

public class PairWithGivenSum {
    public boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                System.out.println("Pair found: " + num + ", " + (target - num));
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        PairWithGivenSum pairChecker = new PairWithGivenSum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter target sum:");
        int target = scanner.nextInt();
        boolean result = pairChecker.hasPairWithSum(arr, target);
        if (!result) {
            System.out.println("No pair found with the given sum.");
        }
    }
}
