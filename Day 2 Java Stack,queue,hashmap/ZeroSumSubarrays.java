import java.util.*;

public class ZeroSumSubarrays {
    public List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumMap.get(cumulativeSum)) {
                    result.add(Arrays.asList(startIndex + 1, i));
                }
            }

            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public void printZeroSumSubarrays(int[] arr) {
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);
        if (subarrays.isEmpty()) {
            System.out.println("No subarrays with zero sum.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (List<Integer> subarray : subarrays) {
                System.out.println("Start: " + subarray.get(0) + ", End: " + subarray.get(1));
            }
        }
    }

    public static void main(String[] args) {
        ZeroSumSubarrays zeroSumSubarrays = new ZeroSumSubarrays();
        int[] arr = { 3, 4, -7, 3, 1, 3, -4, -2 };
        zeroSumSubarrays.printZeroSumSubarrays(arr);
    }
}
