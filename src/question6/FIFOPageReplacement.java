package question6;

import java.util.*;

public class FIFOPageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of page frames
        int frames = sc.nextInt();

        // Input: number of page references
        int n = sc.nextInt();
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        Set<Integer> memory = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int page = pages[i];
            if (memory.contains(page)) {
                // Hit
                System.out.println(page + " : Hit");
            } else {
                // Miss
                if (memory.size() < frames) {
                    memory.add(page);
                    queue.add(page);
                } else {
                    int removed = queue.poll();
                    memory.remove(removed);
                    memory.add(page);
                    queue.add(page);
                }

                // Display current frame state
                System.out.print(page + " : Miss ");
                List<Integer> frameState = new ArrayList<>(queue);
                while (frameState.size() < frames) {
                    frameState.add(-1); // fill empty slots
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
