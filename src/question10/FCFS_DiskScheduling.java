package question10;

import java.util.Scanner;

public class FCFS_DiskScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input head position
        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        // Input number of disk references
        System.out.print("Enter number of disk references: ");
        int n = sc.nextInt();

        // Input disk references
        int[] requests = new int[n];
        System.out.println("Enter disk references:");
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.println("\nDisk movements:");
        int totalMoves = 0;

        for (int i = 0; i < n; i++) {
            int distance = Math.abs(requests[i] - head);
            totalMoves += distance;
            System.out.println(requests[i] + " : " + distance + " moves");
            head = requests[i];
        }

        System.out.println("\nTotal head movement: " + totalMoves + " tracks");
    }
}

