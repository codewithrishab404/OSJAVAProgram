package question2;

import java.util.*;

class Process {
    int pid;
    int bt;

    public Process(int pid, int bt) {
        this.pid = pid;
        this.bt = bt;
    }
}

 class SJF_GanttChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];

        // Input PID and Burst Time
        for (int i = 0; i < n; i++) {
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            processes[i] = new Process(pid, bt);
        }

        // Sort processes by burst time (Shortest Job First)
        Arrays.sort(processes, Comparator.comparingInt(p -> p.bt));

        System.out.println("\nGantt Chart:");
        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            Process p = processes[i];

            // Print start
            System.out.print(currentTime + " : Process " + p.pid + " start\n");

            currentTime += p.bt;

            // Print end/start of next or end of last
            if (i < n - 1) {
                System.out.print(currentTime + " : Process " + p.pid + " end Process " + processes[i + 1].pid + " start\n");
            } else {
                System.out.print(currentTime + " : Process " + p.pid + " end\n");
            }
        }
    }
}

