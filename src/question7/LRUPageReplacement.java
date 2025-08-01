package question7;

import java.util.*;

public class LRUPageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of page frames
        int frames = sc.nextInt();

        // Number of page references
        int n = sc.nextInt();
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        List<Integer> memory = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int page = pages[i];
            if (memory.contains(page)) {
                // Hit
                System.out.println(page + " : Hit");
                // Move this page to the most recently used (end of list)
                memory.remove((Integer) page);
                memory.add(page);
            } else {
                // Miss
                if (memory.size() < frames) {
                    memory.add(page);
                } else {
                    memory.remove(0); // Remove least recently used
                    memory.add(page);
                }

                // Display
                System.out.print(page + " : Miss ");
                List<Integer> frameState = new ArrayList<>(memory);
                while (frameState.size() < frames) {
                    frameState.add(-1);
                }
                for (int f : frameState) {
                    System.out.print(f + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}

