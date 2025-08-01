package question12;

import java.util.*;

public class SCAN_DiskScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: lower and upper bounds of the disk
        System.out.print("Enter lower and upper bounds: ");
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        // Input: Initial head position
        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        // Input: Direction ('l' or 'r')
        System.out.print("Enter initial direction (l for left, r for right): ");
        char direction = sc.next().charAt(0);

        // Input: Number of disk requests
        System.out.print("Enter number of disk references: ");
        int n = sc.nextInt();

        // Input: Disk references
        List<Integer> requests = new ArrayList<>();
        System.out.println("Enter disk references:");
        for (int i = 0; i < n; i++) {
            requests.add(sc.nextInt());
        }

        // Add bounds and current head to the request list for SCAN behavior
        requests.add(head);
        if (direction == 'l') {
            requests.add(lower);
        } else {
            requests.add(upper);
        }

        // Sort the requests
        Collections.sort(requests);

        // Find the index of the current head in the sorted list
        int headIndex = requests.indexOf(head);
        int totalMovement = 0;
        int currentHead = head;

        System.out.println("\nDisk movements:");

        if (direction == 'l') {
            // Move left first
            for (int i = headIndex - 1; i >= 0; i--) {
                int next = requests.get(i);
                int move = Math.abs(currentHead - next);
                System.out.println(next + " : " + move + " moves");
                totalMovement += move;
                currentHead = next;
            }
            // Then move right
            for (int i = headIndex + 1; i < requests.size(); i++) {
                int next = requests.get(i);
                int move = Math.abs(currentHead - next);
                System.out.println(next + " : " + move + " moves");
                totalMovement += move;
                currentHead = next;
            }
        } else {
            // Move right first
            for (int i = headIndex + 1; i < requests.size(); i++) {
                int next = requests.get(i);
                int move = Math.abs(currentHead - next);
                System.out.println(next + " : " + move + " moves");
                totalMovement += move;
                currentHead = next;
            }
            // Then move left
            for (int i = headIndex - 1; i >= 0; i--) {
                int next = requests.get(i);
                int move = Math.abs(currentHead - next);
                System.out.println(next + " : " + move + " moves");
                totalMovement += move;
                currentHead = next;
            }
        }

        System.out.println("\nTotal head movement: " + totalMovement + " tracks");
    }
}

