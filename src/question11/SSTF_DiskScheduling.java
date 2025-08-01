package question11;

import java.util.*;

public class SSTF_DiskScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Head start position
        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        // Input: Number of disk references
        System.out.print("Enter number of disk references: ");
        int n = sc.nextInt();

        // Input: Disk references
        int[] requests = new int[n];
        System.out.println("Enter disk references:");
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        // To keep track of visited requests
        boolean[] visited = new boolean[n];
        int totalMoves = 0;

        System.out.println("\nDisk movements:");

        for (int count = 0; count < n; count++) {
            int minDistance = Integer.MAX_VALUE;
            int index = -1;

            // Find the closest unvisited request
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(requests[i] - head);
                    if (distance < minDistance) {
                        minDistance = distance;
                        index = i;
                    }
                }
            }

            // Visit the closest request
            visited[index] = true;
            totalMoves += minDistance;
            System.out.println(requests[index] + " : " + minDistance + " moves");
            head = requests[index];
        }

        System.out.println("\nTotal head movement: " + totalMoves + " tracks");
    }
}
