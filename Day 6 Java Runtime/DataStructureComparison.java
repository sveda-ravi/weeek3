import java.util.*;

public class DataStructureComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dataset Size (N): ");
        int N = sc.nextInt();

        int[] arr = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = rand.nextInt();
        }

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr) {
            hashSet.add(i);
            treeSet.add(i);
        }

        long startTime, endTime;

        startTime = System.nanoTime();
        arraySearch(arr);
        endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        hashSetSearch(hashSet);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        treeSetSearch(treeSet);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000 + "ms");

        sc.close();
    }

    static void arraySearch(int[] arr) {
        for (int i : arr) {
            if (i == arr[arr.length / 2]) break;
        }
    }

    static void hashSetSearch(HashSet<Integer> set) {
        set.contains(100);
    }

    static void treeSetSearch(TreeSet<Integer> set) {
        set.contains(100);
    }
}
