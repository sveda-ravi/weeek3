import java.util.*;

public class CircularTour {
    public int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int end = 0;
        int currentPetrol = 0;
        int totalPetrol = 0;

        while (end < n) {
            currentPetrol += petrol[end] - distance[end];
            totalPetrol += petrol[end] - distance[end];

            if (currentPetrol < 0) {
                start = end + 1;
                currentPetrol = 0;
            }

            end++;

            if (start == n) {
                return -1;
            }
        }

        return (totalPetrol >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        CircularTour circularTour = new CircularTour();
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startingPump = circularTour.findStartingPump(petrol, distance);
        if (startingPump != -1) {
            System.out.println("The circular tour can be completed starting from pump: " + startingPump);
        } else {
            System.out.println("It's not possible to complete the circular tour.");
        }
    }
}
