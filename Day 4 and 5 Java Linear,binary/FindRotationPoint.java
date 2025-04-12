public class FindRotationPoint {
    public static int findRotationIndex(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // Index of the smallest element
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationPoint = findRotationIndex(arr);
        System.out.println("Rotation point index: " + rotationPoint);
    }
}
